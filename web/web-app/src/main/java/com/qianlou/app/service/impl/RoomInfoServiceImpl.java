package com.qianlou.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.app.cache.RedisCacheUtil;
import com.qianlou.app.mapper.*;
import com.qianlou.app.service.ApartmentInfoService;
import com.qianlou.app.service.BrowsingHistoryService;
import com.qianlou.app.service.RoomInfoService;
import com.qianlou.app.vo.apartment.ApartmentItemVo;
import com.qianlou.app.vo.attr.AttrValueVo;
import com.qianlou.app.vo.fee.FeeValueVo;
import com.qianlou.app.vo.graph.GraphVo;
import com.qianlou.app.vo.room.RoomDetailVo;
import com.qianlou.app.vo.room.RoomItemVo;
import com.qianlou.app.vo.room.RoomQueryVo;
import com.qianlou.common.context.LoginUserContext;
import com.qianlou.model.entity.*;
import com.qianlou.model.enums.ItemType;
import com.qianlou.model.enums.LeaseStatus;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisCacheUtil redisCacheUtil;

    @Resource
    private RoomInfoMapper roomInfoMapper;

    @Resource
    private GraphInfoMapper graphInfoMapper;

    @Resource
    private AttrValueMapper attrValueMapper;

    @Resource
    private FacilityInfoMapper facilityInfoMapper;

    @Resource
    private LabelInfoMapper labelInfoMapper;
    @Resource
    private PaymentTypeMapper paymentTypeMapper;
    @Resource
    private LeaseTermMapper leaseTermMapper;

    @Resource
    private FeeValueMapper feeValueMapper;

    @Resource
    private LeaseAgreementMapper leaseAgreementMapper;

    @Resource
    private BrowsingHistoryService browsingHistoryService;

    @Resource
    private ApartmentInfoService apartmentInfoService;

    // Redis缓存键前缀
    private static final String ROOM_DETAIL_CACHE_KEY = "room:detail:";
    private static final String ROOM_LIST_CACHE_KEY = "room:list:";
    private static final String HOT_ROOMS_CACHE_KEY = "room:hot:";
    
    // 缓存过期时间
    private static final long ROOM_DETAIL_CACHE_TTL = 30L; // 30分钟
    private static final long ROOM_LIST_CACHE_TTL = 10L;   // 10分钟
    private static final long HOT_ROOMS_CACHE_TTL = 60L;   // 60分钟

    //根据公寓ID分页查询房间信息
    @Override
    public IPage<RoomItemVo> pageItemByApartmentId(Page<RoomItemVo> page, Long id) {
        // 构建缓存键
        String cacheKey = ROOM_LIST_CACHE_KEY + "apartment_" + id + "_" + page.getCurrent() + "_" + page.getSize();
        
        // 尝试从缓存获取数据
        IPage<RoomItemVo> cachedResult = null;
        try {
            // 使用getCacheList方法处理泛型类型
            cachedResult = redisCacheUtil.getCacheList(cacheKey, Page.class, RoomItemVo.class);
        } catch (Exception e) {
            // 缓存获取失败时记录日志，继续从数据库查询
            log.warn("Failed to get apartment room list from cache, will query from database, cache key: {}", cacheKey, e);
        }
        
        if (cachedResult != null) {
            log.info("Get apartment room list from cache, cache key: {}", cacheKey);
            return cachedResult;
        }
        
        // 缓存未命中，从数据库查询
        IPage<RoomItemVo> result = roomInfoMapper.pageItemByApartmentId(page, id);
        
        // 存入缓存
        try {
            redisCacheUtil.setCache(cacheKey, result, ROOM_LIST_CACHE_TTL, TimeUnit.MINUTES);
            log.info("Room list stored in cache, cache key: {}", cacheKey);
        } catch (Exception e) {
            // 缓存存储失败时只记录日志，不影响正常业务
            log.warn("Failed to store room list in cache, cache key: {}", cacheKey, e);
        }
        
        return result;
    }

    //根据条件分页查询房间信息
    @Override
    public IPage<RoomItemVo> getRoomItemByQueryForPage(Page<RoomItemVo> page, RoomQueryVo queryVo) {
        // 对于条件查询，为了避免缓存键过多，可以只缓存热门条件组合
        // 这里简化处理，直接查询数据库
        return roomInfoMapper.getRoomItemByQueryForPage(page, queryVo);
    }

    /**
     * 根据房间ID获取房间详细信息
     * @param id 房间ID
     * @return 房间详细信息对象，包含房间基本信息、公寓信息、图片、属性、设施、标签、支付方式、租期和费用等信息
     */
    @Override
    public RoomDetailVo getRoomDetailById(Long id) {
        // 构建缓存键
        String cacheKey = ROOM_DETAIL_CACHE_KEY + id;
        
        // 尝试从缓存获取数据
        RoomDetailVo cachedDetail = redisCacheUtil.getCache(cacheKey, RoomDetailVo.class);
        if (cachedDetail != null) {
            log.info("Get room detail from cache, room ID: {}, cache key: {}", id, cacheKey);
            return cachedDetail;
        }
        
        // 缓存未命中，从数据库查询
        log.info("Cache miss, query room detail from database, room ID: {}", id);
        
        //1.查询RoomInfo - 根据ID获取房间基本信息
        RoomInfo roomInfo = roomInfoMapper.selectRoomById(id);
        if (roomInfo == null) {
            return null;
        }

        //2.查询所属公寓信息 - 获取房间所属的公寓信息
        ApartmentItemVo apartmentItemVo = apartmentInfoService.selectApartmentItemVoById(roomInfo.getApartmentId());

        //3.查询graphInfoList - 获取房间的图片信息列表
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id);

        //4.查询attrValueList - 获取房间的属性值列表
        List<AttrValueVo> attrvalueVoList = attrValueMapper.selectListByRoomId(id);

        //5.查询facilityInfoList - 获取房间的设施信息列表
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);

        //6.查询labelInfoList - 获取房间的标签信息列表
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);

        //7.查询paymentTypeList - 获取房间的支付方式列表
        List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);

        //8.查询leaseTermList - 获取房间的租期列表
        List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(id);

        //9.查询费用项目信息 - 获取公寓的费用项目信息
        List<FeeValueVo> feeValueVoList = feeValueMapper.selectListByApartmentId(roomInfo.getApartmentId());

        //10.查询房间入住状态 - 检查房间是否有已签约或正在退租的租约
        LambdaQueryWrapper<LeaseAgreement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LeaseAgreement::getRoomId, roomInfo.getId());
        queryWrapper.in(LeaseAgreement::getStatus, LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING);
        Long singedCount = leaseAgreementMapper.selectCount(queryWrapper);

        //创建并填充房间详细信息对象
        RoomDetailVo appRoomDetailVo = new RoomDetailVo();
        BeanUtils.copyProperties(roomInfo, appRoomDetailVo);
        appRoomDetailVo.setIsDelete(roomInfo.getIsDeleted() == 1);
        appRoomDetailVo.setIsCheckIn(singedCount > 0);

        //设置房间详细信息对象的各种属性
        appRoomDetailVo.setApartmentItemVo(apartmentItemVo);
        appRoomDetailVo.setGraphVoList(graphVoList);
        appRoomDetailVo.setAttrValueVoList(attrvalueVoList);
        appRoomDetailVo.setFacilityInfoList(facilityInfoList);
        appRoomDetailVo.setLabelInfoList(labelInfoList);
        appRoomDetailVo.setPaymentTypeList(paymentTypeList);
        appRoomDetailVo.setFeeValueVoList(feeValueVoList);
        appRoomDetailVo.setLeaseTermList(leaseTermList);

        // 存入缓存
        redisCacheUtil.setCache(cacheKey, appRoomDetailVo, ROOM_DETAIL_CACHE_TTL, TimeUnit.MINUTES);
        log.info("Room detail stored in cache, room ID: {}, cache key: {}", id, cacheKey);

        //保存用户浏览历史记录
        browsingHistoryService.saveBrowsingHistory(LoginUserContext.getLoginUser().getUserId(), id);
        
        return appRoomDetailVo;
    }
    
    /**
     * 清除房间详情缓存
     * 当房间信息更新时调用此方法
     * @param roomId 房间ID
     */
    public void clearRoomDetailCache(Long roomId) {
        String cacheKey = ROOM_DETAIL_CACHE_KEY + roomId;
        boolean deleted = redisCacheUtil.deleteCache(cacheKey);
        if (deleted) {
            log.info("Room detail cache cleared successfully, room ID: {}, cache key: {}", roomId, cacheKey);
        } else {
            log.info("Failed to clear room detail cache or cache does not exist, room ID: {}, cache key: {}", roomId, cacheKey);
        }
    }
    
    /**
     * 清除指定公寓的房间列表缓存
     * @param apartmentId 公寓ID
     */
    public void clearApartmentRoomListCache(Long apartmentId) {
        // 实际应用中可能需要使用Redis的keys或scan命令模糊匹配删除
        // 这里简化处理，记录日志提示
        log.info("Suggest to clear apartment room list cache, apartment ID: {}", apartmentId);
    }
    
    /**
     * 获取热门房间列表
     * @param limit 限制条数
     * @return 热门房间列表
     */
    @Override
    public List<RoomItemVo> getHotRooms(int limit) {
        // 构建缓存键
        String cacheKey = HOT_ROOMS_CACHE_KEY + limit;
        
        try {
            // 尝试从缓存获取数据
            List<RoomItemVo> cachedHotRooms = redisCacheUtil.getCacheList(cacheKey, RoomItemVo.class);
            if (cachedHotRooms != null) {
                log.info("Get hot rooms list from cache, limit: {}, cache key: {}", limit, cacheKey);
                return cachedHotRooms;
            }
        } catch (Exception e) {
            log.error("Exception when getting hot rooms cache, error message: {}", e.getMessage(), e);
            // 缓存异常时继续从数据库查询
        }
        
        // 缓存未命中或缓存异常，从数据库查询
        log.info("Cache miss or exception, query hot rooms list from database, limit: {}", limit);
        List<RoomItemVo> hotRooms = roomInfoMapper.selectHotRooms(limit);
        
        // 存入缓存（设置过期时间）
        if (hotRooms != null && !hotRooms.isEmpty()) {
            try {
                // 使用redisCacheUtil设置缓存，并指定过期时间
                redisCacheUtil.setCache(cacheKey, hotRooms, HOT_ROOMS_CACHE_TTL, TimeUnit.MINUTES);
                log.info("Hot rooms list stored in cache with TTL: {} minutes, limit: {}, cache key: {}", 
                         HOT_ROOMS_CACHE_TTL, limit, cacheKey);
            } catch (Exception e) {
                log.error("Exception when storing hot rooms list in cache, error message: {}", e.getMessage(), e);
                // 缓存存储异常不影响业务流程
            }
        }
        
        return hotRooms;
    }
    
    /**
     * 清除指定房间的缓存
     * @param roomId 房间ID
     */
    @Override
    public void clearRoomCache(Long roomId) {
        // 清除房间详情缓存
        clearRoomDetailCache(roomId);
        
        // 清除热门房间缓存（所有限制条数的版本）
        // 这里简化处理，记录日志提示
        log.info("Suggest to clear hot rooms cache, affected room ID: {}", roomId);
    }
    
    /**
     * 清除指定公寓的房间列表缓存
     * @param apartmentId 公寓ID
     */
    @Override
    public void clearApartmentRoomCache(Long apartmentId) {
        clearApartmentRoomListCache(apartmentId);
    }
}





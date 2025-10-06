package com.qianlou.app.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.app.vo.room.RoomDetailVo;
import com.qianlou.app.vo.room.RoomItemVo;
import com.qianlou.app.vo.room.RoomQueryVo;
import com.qianlou.model.entity.RoomInfo;
import java.util.List;

public interface RoomInfoService extends IService<RoomInfo> {

    IPage<RoomItemVo> pageItemByApartmentId(Page<RoomItemVo> page, Long id);

    IPage<RoomItemVo> getRoomItemByQueryForPage(Page<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);
    
    /**
     * 获取热门房间列表
     * @param limit 限制条数
     * @return 热门房间列表
     */
    List<RoomItemVo> getHotRooms(int limit);
    
    /**
     * 清除指定房间的缓存
     * @param roomId 房间ID
     */
    void clearRoomCache(Long roomId);
    
    /**
     * 清除指定公寓的房间列表缓存
     * @param apartmentId 公寓ID
     */
    void clearApartmentRoomCache(Long apartmentId);
}

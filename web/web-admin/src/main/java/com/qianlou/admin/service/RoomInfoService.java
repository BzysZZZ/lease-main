package com.qianlou.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.admin.vo.room.RoomDetailVo;
import com.qianlou.admin.vo.room.RoomItemVo;
import com.qianlou.admin.vo.room.RoomQueryVo;
import com.qianlou.admin.vo.room.RoomSubmitVo;
import com.qianlou.model.entity.RoomInfo;

/**
* @description 针对表【room_info(房间信息表)】的数据库操作Service
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> getRoomItemByQueryForPage(IPage<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);

}

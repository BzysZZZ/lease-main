package com.qianlou.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qianlou.admin.vo.room.RoomItemVo;
import com.qianlou.admin.vo.room.RoomQueryVo;
import com.qianlou.model.entity.RoomInfo;

/**
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> getRoomItemByQueryForPage(IPage<RoomItemVo> page, RoomQueryVo queryVo);
}





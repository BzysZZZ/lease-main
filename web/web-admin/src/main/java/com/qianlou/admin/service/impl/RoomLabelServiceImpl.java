package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.RoomLabelMapper;
import com.qianlou.admin.service.RoomLabelService;
import com.qianlou.model.entity.RoomLabel;
import org.springframework.stereotype.Service;

/**
* @description 针对表【room_label(房间&标签关联表)】的数据库操作Service实现
*/
@Service
public class RoomLabelServiceImpl extends ServiceImpl<RoomLabelMapper, RoomLabel>
    implements RoomLabelService {

}





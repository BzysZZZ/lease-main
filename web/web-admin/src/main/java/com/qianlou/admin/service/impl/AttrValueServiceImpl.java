package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.AttrValueMapper;
import com.qianlou.admin.service.AttrValueService;
import com.qianlou.model.entity.AttrValue;
import org.springframework.stereotype.Service;

/**
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service实现
*/
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue>
    implements AttrValueService {

}





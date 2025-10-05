package com.qianlou.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.admin.vo.attr.AttrValueVo;
import com.qianlou.model.entity.AttrValue;

import java.util.List;


/**
* @description 表【attr_value(房间基本属性值表)】Mapper
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);

}





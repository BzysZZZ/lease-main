package com.qianlou.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.admin.vo.attr.AttrKeyVo;
import com.qianlou.model.entity.AttrKey;

import java.util.List;

/**
* @description 表【attr_key(房间基本属性表)】Mapper
*/
public interface AttrKeyMapper extends BaseMapper<AttrKey> {

    List<AttrKeyVo> listAttrInfo();

}





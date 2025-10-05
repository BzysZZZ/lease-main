package com.qianlou.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.admin.vo.fee.FeeValueVo;
import com.qianlou.model.entity.FeeValue;

import java.util.List;

/**
* @description 表【fee_value(杂项费用值表)】Mapper
*/
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    List<FeeValueVo> selectListByApartmentId(Long id);
}





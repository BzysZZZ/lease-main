package com.qianlou.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.admin.vo.fee.FeeKeyVo;
import com.qianlou.model.entity.FeeKey;

import java.util.List;

/**
* @description 表【fee_key(杂项费用名称表)】Mapper
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}





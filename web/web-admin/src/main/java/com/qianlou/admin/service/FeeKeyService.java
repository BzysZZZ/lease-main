package com.qianlou.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.admin.vo.fee.FeeKeyVo;
import com.qianlou.model.entity.FeeKey;

import java.util.List;


/**
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service
*/
public interface FeeKeyService extends IService<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}

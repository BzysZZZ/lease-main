package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.FeeValueMapper;
import com.qianlou.admin.service.FeeValueService;
import com.qianlou.model.entity.FeeValue;
import org.springframework.stereotype.Service;

/**
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Service实现
*/
@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue>
    implements FeeValueService {

}





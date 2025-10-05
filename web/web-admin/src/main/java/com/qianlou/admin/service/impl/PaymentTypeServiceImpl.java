package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.PaymentTypeMapper;
import com.qianlou.admin.service.PaymentTypeService;
import com.qianlou.model.entity.PaymentType;
import org.springframework.stereotype.Service;

/**
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService {

}





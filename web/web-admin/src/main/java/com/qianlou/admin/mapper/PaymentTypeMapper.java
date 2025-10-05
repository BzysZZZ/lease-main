package com.qianlou.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.model.entity.PaymentType;

import java.util.List;


/**
 * @description 表【payment_type(支付方式表)】Mapper
 */
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    List<PaymentType> selectListByRoomId(Long id);
}





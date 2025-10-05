package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.ApartmentFeeValueMapper;
import com.qianlou.admin.service.ApartmentFeeValueService;
import com.qianlou.model.entity.ApartmentFeeValue;
import org.springframework.stereotype.Service;

/**
* @description 针对表【apartment_fee_value(公寓&杂费关联表)】的数据库操作Service实现
*/
@Service
public class ApartmentFeeValueServiceImpl extends ServiceImpl<ApartmentFeeValueMapper, ApartmentFeeValue>
    implements ApartmentFeeValueService {

}





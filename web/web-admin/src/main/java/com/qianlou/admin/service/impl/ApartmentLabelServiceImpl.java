package com.qianlou.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.ApartmentLabelMapper;
import com.qianlou.admin.service.ApartmentLabelService;
import com.qianlou.model.entity.ApartmentLabel;
import org.springframework.stereotype.Service;

/**
* @description 针对表【apartment_label(公寓标签关联表)】的数据库操作Service实现
*/
@Service
public class ApartmentLabelServiceImpl extends ServiceImpl<ApartmentLabelMapper, ApartmentLabel>
    implements ApartmentLabelService {

}





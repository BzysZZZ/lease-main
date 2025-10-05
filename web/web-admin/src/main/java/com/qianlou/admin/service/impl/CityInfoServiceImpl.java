package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.CityInfoMapper;
import com.qianlou.admin.service.CityInfoService;
import com.qianlou.model.entity.CityInfo;
import org.springframework.stereotype.Service;

/**
* @description 针对表【city_info】的数据库操作Service实现
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService {

}





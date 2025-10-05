package com.qianlou.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qianlou.admin.vo.apartment.ApartmentItemVo;
import com.qianlou.admin.vo.apartment.ApartmentQueryVo;
import com.qianlou.model.entity.ApartmentInfo;

/**
* @description 表 apartment_info(公寓信息表) Mapper
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> apartmentItemByQueryForPage(IPage<ApartmentItemVo> page, ApartmentQueryVo queryVo);
}





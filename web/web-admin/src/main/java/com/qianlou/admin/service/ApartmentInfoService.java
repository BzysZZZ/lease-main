package com.qianlou.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.admin.vo.apartment.ApartmentDetailVo;
import com.qianlou.admin.vo.apartment.ApartmentItemVo;
import com.qianlou.admin.vo.apartment.ApartmentQueryVo;
import com.qianlou.admin.vo.apartment.ApartmentSubmitVo;
import com.qianlou.model.entity.ApartmentInfo;

/**
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo);

    IPage<ApartmentItemVo> apartmentItemByQueryForPage(IPage<ApartmentItemVo> page, ApartmentQueryVo queryVo);

    ApartmentDetailVo getApartmentDetailById(Long id);

    void removeApartmentById(Long id);

}

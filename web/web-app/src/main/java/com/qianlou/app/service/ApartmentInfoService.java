package com.qianlou.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.app.vo.apartment.ApartmentDetailVo;
import com.qianlou.app.vo.apartment.ApartmentItemVo;
import com.qianlou.model.entity.ApartmentInfo;

public interface ApartmentInfoService extends IService<ApartmentInfo> {

    ApartmentItemVo selectApartmentItemVoById(Long apartmentId);

    ApartmentDetailVo getApartmentDetailById(Long id);

    ApartmentItemVo getApartmentItemVoById(Long apartmentId);
}

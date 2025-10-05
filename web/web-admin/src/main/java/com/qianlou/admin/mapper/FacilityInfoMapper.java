package com.qianlou.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.model.entity.FacilityInfo;

import java.util.List;

/**
* @description 表【facility_info(配套信息表)】Mapper
*/
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> selectListByApartmentId(Long id);

    List<FacilityInfo> selectListByRoomId(Long id);
}





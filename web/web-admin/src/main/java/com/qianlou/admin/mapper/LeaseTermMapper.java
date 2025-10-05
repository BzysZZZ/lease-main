package com.qianlou.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.model.entity.LeaseTerm;

import java.util.List;

/**
* @description 表【lease_term(租期)】Mapper
*/
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {

    List<LeaseTerm> selectListByRoomId(Long id);
}





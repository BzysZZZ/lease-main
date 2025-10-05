package com.qianlou.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qianlou.admin.vo.system.user.SystemUserItemVo;
import com.qianlou.admin.vo.system.user.SystemUserQueryVo;
import com.qianlou.model.entity.SystemUser;

/**
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    IPage<SystemUserItemVo> getSystemUserByQueryForPage(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUser selectOneByUsername(String username);

}





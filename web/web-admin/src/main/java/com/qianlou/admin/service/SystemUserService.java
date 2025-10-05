package com.qianlou.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.admin.vo.system.user.SystemUserItemVo;
import com.qianlou.admin.vo.system.user.SystemUserQueryVo;
import com.qianlou.model.entity.SystemUser;

/**
* @description 针对表【system_user(员工信息表)】的数据库操作Service
*/
public interface SystemUserService extends IService<SystemUser> {

    IPage<SystemUserItemVo> getSystemUserByQueryForPage(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUserItemVo getSystemUserById(Long id);

}

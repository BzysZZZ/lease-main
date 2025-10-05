package com.qianlou.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.SystemPostMapper;
import com.qianlou.admin.mapper.SystemUserMapper;
import com.qianlou.admin.service.SystemUserService;
import com.qianlou.admin.vo.system.user.SystemUserItemVo;
import com.qianlou.admin.vo.system.user.SystemUserQueryVo;
import com.qianlou.model.entity.SystemPost;
import com.qianlou.model.entity.SystemUser;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

    @Resource
    private SystemUserMapper systemUserMapper;
    @Resource
    private SystemPostMapper systemPostMapper;

    @Override
    public IPage<SystemUserItemVo> getSystemUserByQueryForPage(IPage<SystemUser> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.getSystemUserByQueryForPage(page, queryVo);
    }

    @Override
    public SystemUserItemVo getSystemUserById(Long id) {
        SystemUser systemUser = systemUserMapper.selectById(id);
        SystemPost systemPost = systemPostMapper.selectById(systemUser.getPostId());
        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemPost, systemUserItemVo);
        systemUserItemVo.setPostName(systemUserItemVo.getPostName());
        return systemUserItemVo;
    }
}





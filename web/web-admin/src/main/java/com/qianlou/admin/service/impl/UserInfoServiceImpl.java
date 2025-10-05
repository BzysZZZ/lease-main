package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.UserInfoMapper;
import com.qianlou.admin.service.UserInfoService;
import com.qianlou.model.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

}





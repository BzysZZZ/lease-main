package com.qianlou.admin.service;


import com.qianlou.admin.vo.login.CaptchaVo;
import com.qianlou.admin.vo.login.LoginVo;
import com.qianlou.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getSystemUserInfoById(Long userId);
}

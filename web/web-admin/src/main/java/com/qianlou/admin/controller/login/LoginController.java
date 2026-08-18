package com.qianlou.admin.controller.login;


import com.qianlou.admin.service.LoginService;
import com.qianlou.admin.vo.login.CaptchaVo;
import com.qianlou.admin.vo.login.LoginVo;
import com.qianlou.admin.vo.system.user.SystemUserInfoVo;
import com.qianlou.common.context.LoginUserContext;
import com.qianlou.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo captcha = loginService.getCaptcha();

        return Result.ok(captcha);
    }

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String token = loginService.login(loginVo);
        return Result.ok(token);
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        SystemUserInfoVo user = loginService.getSystemUserInfoById(LoginUserContext.getLoginUser().getUserId());
        return Result.ok(user);
    }
}
package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.domain.UserDto;
import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员登录注册管理Controller Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController", value = "会员登录注册管理")
@RequestMapping("/sso")
@SuppressWarnings("rawtypes")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("会员注册")
    @PostMapping("/register")
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        memberService.register(username, password, telephone, authCode);
        return CommonResult.success(null, "注册成功");
    }

    @ApiOperation("会员登录")
    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password) {
        return memberService.login(username, password);
    }

    @ApiOperation("获取会员信息")
    @GetMapping("/info")
    @ResponseBody
    public CommonResult info() {
        UmsMember member = memberService.getCurrentMember();
        return CommonResult.success(member);
    }

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        String authCode = memberService.generateAuthCode(telephone);
        return CommonResult.success(authCode, "获取验证码成功");
    }

    @ApiOperation("修改密码")
    @PostMapping("/updatePassword")
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String password,
                                       @RequestParam String authCode) {
        memberService.updatePassword(telephone, password, authCode);
        return CommonResult.success(null, "密码修改成功");
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @GetMapping("/loadByUsername")
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam String username) {
        return memberService.loadUserByUsername(username);
    }
}

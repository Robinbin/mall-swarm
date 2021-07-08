package com.macro.mall.demo.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.demo.service.FeignPortalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign调用mall-portal接口示例 Created by macro on 2019/10/18.
 */
@Api(tags = "FeignPortalController", value = "Feign调用mall-portal接口示例")
@RestController
@RequestMapping("/feign/portal")
@SuppressWarnings("rawtypes")
public class FeignPortalController {

    @Autowired
    private FeignPortalService portalService;

    @PostMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password) {
        return portalService.login(username, password);
    }

    @GetMapping("/cartList")
    public CommonResult cartList() {
        return portalService.list();
    }
}

package com.macro.mall.controller;


import com.macro.mall.dto.OssCallbackResult;
import com.macro.mall.dto.OssPolicyResult;
import com.macro.mall.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss相关操作接口 Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "OssController", value = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {

    @Autowired
    private OssServiceImpl ossService;

    @ApiOperation(value = "oss上传签名生成")
    @GetMapping("/policy")
    public OssPolicyResult policy() {
        return ossService.policy();
    }

    @ApiOperation(value = "oss上传成功回调")
    @PostMapping("callback")
    public OssCallbackResult callback(HttpServletRequest request) {
        return ossService.callback(request);
    }

}

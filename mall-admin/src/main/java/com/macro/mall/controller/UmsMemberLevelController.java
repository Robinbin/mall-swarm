package com.macro.mall.controller;

import com.macro.mall.model.UmsMemberLevel;
import com.macro.mall.service.UmsMemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员等级管理Controller Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "UmsMemberLevelController", value = "会员等级管理")
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {

    @Autowired
    private UmsMemberLevelService memberLevelService;

    @GetMapping("/list")
    @ApiOperation("查询所有会员等级")
    public List<UmsMemberLevel> list(@RequestParam("defaultStatus") Integer defaultStatus) {
        return memberLevelService.list(defaultStatus);
    }
}

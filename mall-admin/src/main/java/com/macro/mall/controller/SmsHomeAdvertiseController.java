package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.SmsHomeAdvertise;
import com.macro.mall.service.SmsHomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页轮播广告管理Controller Created by macro on 2018/11/7.
 */
@RestController
@Api(tags = "SmsHomeAdvertiseController", value = "首页轮播广告管理")
@RequestMapping("/home/advertise")
public class SmsHomeAdvertiseController {

    @Autowired
    private SmsHomeAdvertiseService advertiseService;

    @ApiOperation("添加广告")
    @PostMapping("/create")
    public int create(@RequestBody SmsHomeAdvertise advertise) {
        return advertiseService.create(advertise);
    }

    @ApiOperation("删除广告")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return advertiseService.delete(ids);
    }

    @ApiOperation("修改上下线状态")
    @PostMapping("/update/status/{id}")
    public int updateStatus(@PathVariable Long id, Integer status) {
        return advertiseService.updateStatus(id, status);
    }

    @ApiOperation("获取广告详情")
    @GetMapping("/{id}")
    public SmsHomeAdvertise getItem(@PathVariable Long id) {
        return advertiseService.getItem(id);
    }

    @ApiOperation("修改广告")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody SmsHomeAdvertise advertise) {
        return advertiseService.update(id, advertise);
    }

    @ApiOperation("分页查询广告")
    @GetMapping("/list")
    public CommonPage<SmsHomeAdvertise> list(@RequestParam(value = "name", required = false) String name,
                                             @RequestParam(value = "type", required = false) Integer type,
                                             @RequestParam(value = "endTime", required = false) String endTime,
                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(advertiseService.list(name, type, endTime, pageSize, pageNum));
    }
}

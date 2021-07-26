package com.macro.mall.controller;

import com.macro.mall.model.OmsOrderSetting;
import com.macro.mall.service.OmsOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单设置Controller Created by macro on 2018/10/16.
 */
@RestController
@Api(tags = "OmsOrderSettingController", value = "订单设置管理")
@RequestMapping("/orderSetting")
public class OmsOrderSettingController {

    @Autowired
    private OmsOrderSettingService orderSettingService;

    @ApiOperation("获取指定订单设置")
    @GetMapping("/{id}")
    public OmsOrderSetting getItem(@PathVariable Long id) {
        return orderSettingService.getItem(id);
    }

    @ApiOperation("修改指定订单设置")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody OmsOrderSetting orderSetting) {
        return orderSettingService.update(id, orderSetting);
    }
}

package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.model.SmsCoupon;
import com.macro.mall.service.SmsCouponService;
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

/**
 * 优惠券管理Controller Created by macro on 2018/8/28.
 */
@RestController
@Api(tags = "SmsCouponController", value = "优惠券管理")
@RequestMapping("/coupon")
public class SmsCouponController {

    @Autowired
    private SmsCouponService couponService;

    @ApiOperation("添加优惠券")
    @PostMapping("/create")
    public int add(@RequestBody SmsCouponParam couponParam) {
        return couponService.create(couponParam);
    }

    @ApiOperation("删除优惠券")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return couponService.delete(id);
    }

    @ApiOperation("修改优惠券")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody SmsCouponParam couponParam) {
        return couponService.update(id, couponParam);
    }

    @ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
    @GetMapping("/list")
    public CommonPage<SmsCoupon> list(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "type", required = false) Integer type,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(couponService.list(name, type, pageSize, pageNum));
    }

    @ApiOperation("获取单个优惠券的详细信息")
    @GetMapping("/{id}")
    public SmsCouponParam getItem(@PathVariable Long id) {
        return couponService.getItem(id);
    }
}

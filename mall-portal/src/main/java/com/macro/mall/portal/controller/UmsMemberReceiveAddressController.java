package com.macro.mall.portal.controller;

import com.macro.mall.model.UmsMemberReceiveAddress;
import com.macro.mall.portal.service.UmsMemberReceiveAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员收货地址管理Controller Created by macro on 2018/8/28.
 */
@RestController
@Api(tags = "UmsMemberReceiveAddressController", value = "会员收货地址管理")
@RequestMapping("/member/address")
public class UmsMemberReceiveAddressController {

    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;

    @ApiOperation("添加收货地址")
    @PostMapping("/add")
    public int add(@RequestBody UmsMemberReceiveAddress address) {
        return memberReceiveAddressService.add(address);
    }

    @ApiOperation("删除收货地址")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return memberReceiveAddressService.delete(id);
    }

    @ApiOperation("修改收货地址")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody UmsMemberReceiveAddress address) {
        return memberReceiveAddressService.update(id, address);
    }

    @ApiOperation("显示所有收货地址")
    @GetMapping("/list")
    public List<UmsMemberReceiveAddress> list() {
        return memberReceiveAddressService.list();
    }

    @ApiOperation("获取收货地址详情")
    @GetMapping("/{id}")
    public UmsMemberReceiveAddress getItem(@PathVariable Long id) {
        return memberReceiveAddressService.getItem(id);
    }
}

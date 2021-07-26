package com.macro.mall.controller;

import com.macro.mall.model.OmsCompanyAddress;
import com.macro.mall.service.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收货地址管理Controller Created by macro on 2018/10/18.
 */
@RestController
@Api(tags = "OmsCompanyAddressController", value = "收货地址管理")
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {

    @Autowired
    private OmsCompanyAddressService companyAddressService;

    @ApiOperation("获取所有收货地址")
    @GetMapping("/list")
    public List<OmsCompanyAddress> list() {
        return companyAddressService.list();
    }
}

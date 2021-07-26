package com.macro.mall.controller;

import com.macro.mall.model.CmsPrefrenceArea;
import com.macro.mall.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品优选管理Controller Created by macro on 2018/6/1.
 */
@RestController
@Api(tags = "CmsPrefrenceAreaController", value = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {

    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @GetMapping("/listAll")
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaService.listAll();
    }
}

package com.macro.mall.controller;

import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.service.PmsSkuStockService;
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
 * sku库存Controller Created by macro on 2018/4/27.
 */
@RestController
@Api(tags = "PmsSkuStockController", value = "sku商品库存管理")
@RequestMapping("/sku")
public class PmsSkuStockController {

    @Autowired
    private PmsSkuStockService skuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @GetMapping("/{pid}")
    public List<PmsSkuStock> getList(@PathVariable Long pid,
                                     @RequestParam(value = "keyword", required = false) String keyword) {
        return skuStockService.getList(pid, keyword);
    }

    @ApiOperation("批量更新库存信息")
    @PostMapping("/update/{pid}")
    public int update(@PathVariable Long pid, @RequestBody List<PmsSkuStock> skuStockList) {
        return skuStockService.update(pid, skuStockList);
    }
}

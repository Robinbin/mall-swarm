package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.PmsProductAttributeCategoryItem;
import com.macro.mall.model.PmsProductAttributeCategory;
import com.macro.mall.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品属性分类Controller Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "PmsProductAttributeCategoryController", value = "商品属性分类管理")
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {

    @Autowired
    private PmsProductAttributeCategoryService productAttributeCategoryService;

    @ApiOperation("添加商品属性分类")
    @PostMapping("/create")
    public int create(@RequestParam String name) {
        return productAttributeCategoryService.create(name);
    }

    @ApiOperation("修改商品属性分类")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestParam String name) {
        return productAttributeCategoryService.update(id, name);
    }

    @ApiOperation("删除单个商品属性分类")
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return productAttributeCategoryService.delete(id);
    }

    @ApiOperation("获取单个商品属性分类信息")
    @GetMapping("/{id}")
    public PmsProductAttributeCategory getItem(@PathVariable Long id) {
        return productAttributeCategoryService.getItem(id);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @GetMapping("/list")
    public CommonPage<PmsProductAttributeCategory> getList(
        @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(productAttributeCategoryService.getList(pageSize, pageNum));
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @GetMapping("/list/withAttr")
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryService.getListWithAttr();
    }
}

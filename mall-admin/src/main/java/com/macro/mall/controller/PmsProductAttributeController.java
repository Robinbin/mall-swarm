package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.PmsProductAttributeParam;
import com.macro.mall.dto.ProductAttrInfo;
import com.macro.mall.model.PmsProductAttribute;
import com.macro.mall.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * 商品属性管理Controller Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "PmsProductAttributeController", value = "商品属性管理")
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {

    @Autowired
    private PmsProductAttributeService productAttributeService;

    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "0表示属性，1表示参数", required = true, paramType = "query", dataType = "integer")})
    @GetMapping("/list/{cid}")
    public CommonPage<PmsProductAttribute> getList(@PathVariable Long cid,
                                                   @RequestParam(value = "type") Integer type,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(productAttributeService.getList(cid, type, pageSize, pageNum));
    }

    @ApiOperation("添加商品属性信息")
    @PostMapping("/create")
    public int create(@RequestBody PmsProductAttributeParam productAttributeParam) {
        return productAttributeService.create(productAttributeParam);
    }

    @ApiOperation("修改商品属性信息")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody PmsProductAttributeParam productAttributeParam) {
        return productAttributeService.update(id, productAttributeParam);
    }

    @ApiOperation("查询单个商品属性")
    @GetMapping("/{id}")
    public PmsProductAttribute getItem(@PathVariable Long id) {
        return productAttributeService.getItem(id);
    }

    @ApiOperation("批量删除商品属性")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return productAttributeService.delete(ids);
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @GetMapping("/attrInfo/{productCategoryId}")
    public List<ProductAttrInfo> getAttrInfo(@PathVariable Long productCategoryId) {
        return productAttributeService.getProductAttrInfo(productCategoryId);
    }
}

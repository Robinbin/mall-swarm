package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类模块Controller Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "PmsProductCategoryController", value = "商品分类管理")
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService productCategoryService;

    @ApiOperation("添加产品分类")
    @PostMapping("/create")
    public int create(@Validated @RequestBody PmsProductCategoryParam productCategoryParam) {
        return productCategoryService.create(productCategoryParam);
    }

    @ApiOperation("修改商品分类")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id,
                      @Validated
                      @RequestBody PmsProductCategoryParam productCategoryParam) {
        return productCategoryService.update(id, productCategoryParam);
    }

    @ApiOperation("分页查询商品分类")
    @GetMapping("/list/{parentId}")
    public CommonPage<PmsProductCategory> getList(@PathVariable Long parentId,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(productCategoryService.getList(parentId, pageSize, pageNum));
    }

    @ApiOperation("根据id获取商品分类")
    @GetMapping("/{id}")
    public PmsProductCategory getItem(@PathVariable Long id) {
        return productCategoryService.getItem(id);
    }

    @ApiOperation("删除商品分类")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return productCategoryService.delete(id);
    }

    @ApiOperation("修改导航栏显示状态")
    @PostMapping("/update/navStatus")
    public int updateNavStatus(@RequestParam("ids") List<Long> ids,
                               @RequestParam("navStatus") Integer navStatus) {
        return productCategoryService.updateNavStatus(ids, navStatus);
    }

    @ApiOperation("修改显示状态")
    @PostMapping("/update/showStatus")
    public int updateShowStatus(@RequestParam("ids") List<Long> ids,
                                @RequestParam("showStatus") Integer showStatus) {
        return productCategoryService.updateShowStatus(ids, showStatus);
    }

    @ApiOperation("查询所有一级分类及子分类")
    @GetMapping("/list/withChildren")
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryService.listWithChildren();
    }
}

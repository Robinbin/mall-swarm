package com.macro.mall.portal.controller;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.portal.domain.HomeContentResult;
import com.macro.mall.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页内容管理Controller Created by macro on 2019/1/28.
 */
@RestController
@Api(tags = "HomeController", value = "首页内容管理")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation("首页内容页信息展示")
    @GetMapping("/content")
    public HomeContentResult content() {
        return homeService.content();
    }

    @ApiOperation("分页获取推荐商品")
    @GetMapping("/recommendProductList")
    public List<PmsProduct> recommendProductList(
        @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return homeService.recommendProductList(pageSize, pageNum);
    }

    @ApiOperation("获取首页商品分类")
    @GetMapping("/productCateList/{parentId}")
    public List<PmsProductCategory> getProductCateList(@PathVariable Long parentId) {
        return homeService.getProductCateList(parentId);
    }

    @ApiOperation("根据分类获取专题")
    @GetMapping("/subjectList")
    public List<CmsSubject> getSubjectList(@RequestParam(required = false) Long cateId,
                                           @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return homeService.getSubjectList(cateId, pageSize, pageNum);
    }

    @ApiOperation("分页获取人气推荐商品")
    @GetMapping("/hotProductList")
    public List<PmsProduct> hotProductList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        return homeService.hotProductList(pageNum, pageSize);
    }

    @ApiOperation("分页获取新品推荐商品")
    @GetMapping("/newProductList")
    public List<PmsProduct> newProductList(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        return homeService.newProductList(pageNum, pageSize);
    }
}

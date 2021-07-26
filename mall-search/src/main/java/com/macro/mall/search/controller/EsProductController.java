package com.macro.mall.search.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.search.domain.EsProduct;
import com.macro.mall.search.domain.EsProductRelatedInfo;
import com.macro.mall.search.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * 搜索商品管理Controller Created by macro on 2018/6/19.
 */
@RestController
@Api(tags = "EsProductController", value = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {

    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @PostMapping("/importAll")
    public Integer importAllList() {
        return esProductService.importAll();
    }

    @ApiOperation(value = "根据id删除商品")
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        esProductService.delete(id);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @PostMapping("/delete/batch")
    public void delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
    }

    @ApiOperation(value = "根据id创建商品")
    @PostMapping("/create/{id}")
    public EsProduct create(@PathVariable Long id) {
        return esProductService.create(id);
    }

    @ApiOperation(value = "简单搜索")
    @GetMapping("/search/simple")
    public CommonPage<EsProduct> search(@RequestParam(required = false) String keyword,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        return CommonPage.restPage(esProductService.search(keyword, pageNum, pageSize));
    }

    @ApiOperation(value = "综合搜索、筛选、排序")
    @ApiImplicitParam(name = "sort", value = "排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低",
        defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    @GetMapping("/search")
    public CommonPage<EsProduct> search(@RequestParam(required = false) String keyword,
                                        @RequestParam(required = false) Long brandId,
                                        @RequestParam(required = false) Long productCategoryId,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                        @RequestParam(required = false, defaultValue = "0") Integer sort) {
        return CommonPage
            .restPage(esProductService.search(keyword, brandId, productCategoryId, pageNum, pageSize, sort));
    }

    @ApiOperation(value = "根据商品id推荐商品")
    @GetMapping("/recommend/{id}")
    public CommonPage<EsProduct> recommend(@PathVariable Long id,
                                           @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        return CommonPage.restPage(esProductService.recommend(id, pageNum, pageSize));
    }

    @ApiOperation(value = "获取搜索的相关品牌、分类及筛选属性")
    @GetMapping("/search/relate")
    public EsProductRelatedInfo searchRelatedInfo(@RequestParam(required = false) String keyword) {
        return esProductService.searchRelatedInfo(keyword);
    }
}

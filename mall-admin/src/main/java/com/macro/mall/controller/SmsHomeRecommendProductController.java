package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.SmsHomeRecommendProduct;
import com.macro.mall.service.SmsHomeRecommendProductService;
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
 * 首页人气推荐管理Controller Created by macro on 2018/11/6.
 */
@RestController
@Api(tags = "SmsHomeRecommendProductController", value = "首页人气推荐管理")
@RequestMapping("/home/recommendProduct")
public class SmsHomeRecommendProductController {

    @Autowired
    private SmsHomeRecommendProductService recommendProductService;

    @ApiOperation("添加首页推荐")
    @PostMapping("/create")
    public int create(@RequestBody List<SmsHomeRecommendProduct> homeBrandList) {
        return recommendProductService.create(homeBrandList);
    }

    @ApiOperation("修改推荐排序")
    @PostMapping("/update/sort/{id}")
    public int updateSort(@PathVariable Long id, Integer sort) {
        return recommendProductService.updateSort(id, sort);
    }

    @ApiOperation("批量删除推荐")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return recommendProductService.delete(ids);
    }

    @ApiOperation("批量修改推荐状态")
    @PostMapping("/update/recommendStatus")
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam Integer recommendStatus) {
        return recommendProductService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("分页查询推荐")
    @GetMapping("/list")
    public CommonPage<SmsHomeRecommendProduct> list(
        @RequestParam(value = "productName", required = false) String productName,
        @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(recommendProductService.list(productName, recommendStatus, pageSize, pageNum));
    }
}

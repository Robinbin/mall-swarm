package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.SmsHomeBrand;
import com.macro.mall.service.SmsHomeBrandService;
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
 * 首页品牌管理Controller Created by macro on 2018/11/6.
 */
@RestController
@Api(tags = "SmsHomeBrandController", value = "首页品牌管理")
@RequestMapping("/home/brand")
public class SmsHomeBrandController {

    @Autowired
    private SmsHomeBrandService homeBrandService;

    @ApiOperation("添加首页推荐品牌")
    @PostMapping("/create")
    public int create(@RequestBody List<SmsHomeBrand> homeBrandList) {
        return homeBrandService.create(homeBrandList);
    }

    @ApiOperation("修改品牌排序")
    @PostMapping("/update/sort/{id}")
    public int updateSort(@PathVariable Long id, Integer sort) {
        return homeBrandService.updateSort(id, sort);
    }

    @ApiOperation("批量删除推荐品牌")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return homeBrandService.delete(ids);
    }

    @ApiOperation("批量修改推荐状态")
    @PostMapping("/update/recommendStatus")
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam Integer recommendStatus) {
        return homeBrandService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("分页查询推荐品牌")
    @GetMapping("/list")
    public CommonPage<SmsHomeBrand> list(
        @RequestParam(value = "brandName", required = false) String brandName,
        @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(homeBrandService.list(brandName, recommendStatus, pageSize, pageNum));
    }
}

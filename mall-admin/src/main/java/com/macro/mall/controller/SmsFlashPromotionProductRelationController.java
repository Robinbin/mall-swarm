package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.SmsFlashPromotionProduct;
import com.macro.mall.model.SmsFlashPromotionProductRelation;
import com.macro.mall.service.SmsFlashPromotionProductRelationService;
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
 * 限时购和商品关系管理Controller Created by macro on 2018/11/16.
 */
@RestController
@Api(tags = "SmsFlashPromotionProductRelationController", value = "限时购和商品关系管理")
@RequestMapping("/flashProductRelation")
public class SmsFlashPromotionProductRelationController {

    @Autowired
    private SmsFlashPromotionProductRelationService relationService;

    @ApiOperation("批量选择商品添加关联")
    @PostMapping("/create")
    public int create(@RequestBody List<SmsFlashPromotionProductRelation> relationList) {
        return relationService.create(relationList);
    }

    @ApiOperation("修改关联相关信息")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody SmsFlashPromotionProductRelation relation) {
        return relationService.update(id, relation);
    }

    @ApiOperation("删除关联")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return relationService.delete(id);
    }

    @ApiOperation("获取管理商品促销信息")
    @GetMapping("/{id}")
    public SmsFlashPromotionProductRelation getItem(@PathVariable Long id) {
        return relationService.getItem(id);
    }

    @ApiOperation("分页查询不同场次关联及商品信息")
    @GetMapping("/list")
    public CommonPage<SmsFlashPromotionProduct> list(
        @RequestParam(value = "flashPromotionId") Long flashPromotionId,
        @RequestParam(value = "flashPromotionSessionId") Long flashPromotionSessionId,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(relationService.list(flashPromotionId, flashPromotionSessionId, pageSize, pageNum));
    }
}

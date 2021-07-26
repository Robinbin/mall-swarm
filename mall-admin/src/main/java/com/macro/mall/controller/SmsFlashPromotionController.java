package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.SmsFlashPromotion;
import com.macro.mall.service.SmsFlashPromotionService;
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

/**
 * 限时购活动管理Controller Created by macro on 2018/11/16.
 */
@RestController
@Api(tags = "SmsFlashPromotionController", value = "限时购活动管理")
@RequestMapping("/flash")
public class SmsFlashPromotionController {

    @Autowired
    private SmsFlashPromotionService flashPromotionService;

    @ApiOperation("添加活动")
    @PostMapping("/create")
    public int create(@RequestBody SmsFlashPromotion flashPromotion) {
        return flashPromotionService.create(flashPromotion);
    }

    @ApiOperation("编辑活动信息")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody SmsFlashPromotion flashPromotion) {
        return flashPromotionService.update(id, flashPromotion);
    }

    @ApiOperation("删除活动信息")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return flashPromotionService.delete(id);
    }

    @ApiOperation("修改上下线状态")
    @PostMapping("/update/status/{id}")
    public int update(@PathVariable Long id, Integer status) {
        return flashPromotionService.updateStatus(id, status);
    }

    @ApiOperation("获取活动详情")
    @GetMapping("/{id}")
    public SmsFlashPromotion getItem(@PathVariable Long id) {
        return flashPromotionService.getItem(id);
    }

    @ApiOperation("根据活动名称分页查询")
    @GetMapping("/list")
    public CommonPage<SmsFlashPromotion> getItem(@RequestParam(value = "keyword", required = false) String keyword,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(flashPromotionService.list(keyword, pageSize, pageNum));
    }
}

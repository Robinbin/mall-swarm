package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.portal.domain.MemberBrandAttention;
import com.macro.mall.portal.service.MemberAttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员关注品牌管理Controller Created by macro on 2018/8/2.
 */
@RestController
@Api(tags = "MemberAttentionController", value = "会员关注品牌管理")
@RequestMapping("/member/attention")
public class MemberAttentionController {

    @Autowired
    private MemberAttentionService memberAttentionService;

    @ApiOperation("添加品牌关注")
    @PostMapping("/add")
    public int add(@RequestBody MemberBrandAttention memberBrandAttention) {
        return memberAttentionService.add(memberBrandAttention);
    }

    @ApiOperation("取消关注")
    @PostMapping("/delete")
    public int delete(Long brandId) {
        return memberAttentionService.delete(brandId);
    }

    @ApiOperation("显示关注列表")
    @GetMapping("/list")
    public CommonPage<MemberBrandAttention> list(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonPage.restPage(memberAttentionService.list(pageNum, pageSize));
    }

    @ApiOperation("显示关注品牌详情")
    @GetMapping("/detail")
    public MemberBrandAttention detail(@RequestParam Long brandId) {
        return memberAttentionService.detail(brandId);
    }

    @ApiOperation("清空关注列表")
    @PostMapping("/clear")
    public void clear() {
        memberAttentionService.clear();
    }
}

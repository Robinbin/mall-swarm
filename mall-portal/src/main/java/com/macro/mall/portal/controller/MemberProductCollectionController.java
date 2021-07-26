package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.portal.domain.MemberProductCollection;
import com.macro.mall.portal.service.MemberCollectionService;
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
 * 会员收藏管理Controller Created by macro on 2018/8/2.
 */
@RestController
@Api(tags = "MemberCollectionController", value = "会员收藏管理")
@RequestMapping("/member/productCollection")
public class MemberProductCollectionController {

    @Autowired
    private MemberCollectionService memberCollectionService;

    @ApiOperation("添加商品收藏")
    @PostMapping("/add")
    public int add(@RequestBody MemberProductCollection productCollection) {
        return memberCollectionService.add(productCollection);
    }

    @ApiOperation("删除收藏商品")
    @PostMapping("/delete")
    public int delete(Long productId) {
        return memberCollectionService.delete(productId);
    }

    @ApiOperation("显示收藏列表")
    @GetMapping("/list")
    public CommonPage<MemberProductCollection> list(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonPage.restPage(memberCollectionService.list(pageNum, pageSize));
    }

    @ApiOperation("显示收藏商品详情")
    @GetMapping("/detail")
    public MemberProductCollection detail(@RequestParam Long productId) {
        return memberCollectionService.detail(productId);
    }

    @ApiOperation("清空收藏列表")
    @PostMapping("/clear")
    public void clear() {
        memberCollectionService.clear();
    }
}

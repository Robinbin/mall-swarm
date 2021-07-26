package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.MemberReadHistory;
import com.macro.mall.portal.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员商品浏览记录管理Controller Created by macro on 2018/8/3.
 */
@RestController
@Api(tags = "MemberReadHistoryController", value = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @PostMapping("/create")
    public int create(@RequestBody MemberReadHistory memberReadHistory) {
        return memberReadHistoryService.create(memberReadHistory);
    }

    @ApiOperation("删除浏览记录")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<String> ids) {
        return memberReadHistoryService.delete(ids);
    }

    @ApiOperation("清空除浏览记录")
    @PostMapping("/clear")
    public void clear() {
        memberReadHistoryService.clear();
    }

    @ApiOperation("分页获取用户浏览记录")
    @GetMapping("/list")
    public CommonResult<CommonPage<MemberReadHistory>> list(
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<MemberReadHistory> page = memberReadHistoryService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }
}

package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.CmsSubject;
import com.macro.mall.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品专题管理Controller Created by macro on 2018/6/1.
 */
@RestController
@Api(tags = "CmsSubjectController", value = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {

    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @GetMapping("/listAll")
    public List<CmsSubject> listAll() {
        return subjectService.listAll();
    }

    @ApiOperation(value = "根据专题名称分页获取专题")
    @GetMapping("/list")
    public CommonPage<CmsSubject> getList(
        @RequestParam(value = "keyword", required = false) String keyword,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonPage.restPage(subjectService.list(keyword, pageNum, pageSize));
    }
}

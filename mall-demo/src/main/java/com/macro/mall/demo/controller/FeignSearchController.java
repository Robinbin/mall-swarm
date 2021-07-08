package com.macro.mall.demo.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.demo.service.FeignSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign调用mall-search接口示例 Created by macro on 2019/10/22.
 */
@Api(tags = "FeignSearchController", value = "Feign调用mall-search接口示例")
@RestController
@RequestMapping("/feign/search")
@SuppressWarnings("rawtypes")
public class FeignSearchController {

    @Autowired
    private FeignSearchService feignSearchService;

    @ApiOperation(value = "简单商品搜索")
    @GetMapping("/justSearch")
    @ResponseBody
    public CommonResult search(@RequestParam(required = false) String keyword,
                               @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                               @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        return feignSearchService.search(keyword, pageNum, pageSize);
    }

    @ApiOperation(value = "导入商品")
    @PostMapping("/importAll")
    @ResponseBody
    public CommonResult<Integer> importAll() {
        return feignSearchService.importAllList();
    }
}

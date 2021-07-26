package com.macro.mall.demo.service;

import com.macro.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by macro on 2019/10/22.
 */
@FeignClient("mall-search")
@SuppressWarnings("rawtypes")
public interface FeignSearchService {

    @GetMapping("/esProduct/search/simple")
    CommonResult search(@RequestParam(required = false) String keyword,
                        @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "5") Integer pageSize);

    @PostMapping("/esProduct/importAll")
    CommonResult importAllList();

    @PostMapping("/esProduct/create/{id}")
    CommonResult create(@PathVariable Long id);
}

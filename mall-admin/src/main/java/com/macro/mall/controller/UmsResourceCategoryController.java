package com.macro.mall.controller;

import com.macro.mall.model.UmsResourceCategory;
import com.macro.mall.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台资源分类管理Controller Created by macro on 2020/2/5.
 */
@RestController
@Api(tags = "UmsResourceCategoryController", value = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {

    @Autowired
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @GetMapping("/listAll")
    public List<UmsResourceCategory> listAll() {
        return resourceCategoryService.listAll();
    }

    @ApiOperation("添加后台资源分类")
    @PostMapping("/create")
    public int create(@RequestBody UmsResourceCategory umsResourceCategory) {
        return resourceCategoryService.create(umsResourceCategory);
    }

    @ApiOperation("修改后台资源分类")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id,
                      @RequestBody UmsResourceCategory umsResourceCategory) {
        return resourceCategoryService.update(id, umsResourceCategory);
    }

    @ApiOperation("根据ID删除后台资源")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return resourceCategoryService.delete(id);
    }
}

package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.UmsResource;
import com.macro.mall.service.UmsResourceService;
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
import java.util.Map;

/**
 * 后台资源管理Controller Created by macro on 2020/2/4.
 */
@RestController
@Api(tags = "UmsResourceController", value = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {

    @Autowired
    private UmsResourceService resourceService;

    @ApiOperation("添加后台资源")
    @PostMapping("/create")
    public int create(@RequestBody UmsResource umsResource) {
        return resourceService.create(umsResource);
    }

    @ApiOperation("修改后台资源")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id,
                      @RequestBody UmsResource umsResource) {
        return resourceService.update(id, umsResource);
    }

    @ApiOperation("根据ID获取资源详情")
    @GetMapping("/{id}")
    public UmsResource getItem(@PathVariable Long id) {
        return resourceService.getItem(id);
    }

    @ApiOperation("根据ID删除后台资源")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return resourceService.delete(id);
    }

    @ApiOperation("分页模糊查询后台资源")
    @GetMapping("/list")
    public CommonPage<UmsResource> list(@RequestParam(required = false) Long categoryId,
                                        @RequestParam(required = false) String nameKeyword,
                                        @RequestParam(required = false) String urlKeyword,
                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(resourceService.list(categoryId, nameKeyword, urlKeyword, pageSize, pageNum));
    }

    @ApiOperation("查询所有后台资源")
    @GetMapping("/listAll")
    public List<UmsResource> listAll() {
        return resourceService.listAll();
    }

    @ApiOperation("初始化资源角色关联数据")
    @GetMapping("/initResourceRolesMap")
    public Map<String, List<String>> initResourceRolesMap() {
        return resourceService.initResourceRolesMap();
    }
}

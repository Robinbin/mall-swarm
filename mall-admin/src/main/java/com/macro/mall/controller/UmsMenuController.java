package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.UmsMenuNode;
import com.macro.mall.model.UmsMenu;
import com.macro.mall.service.UmsMenuService;
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
 * 后台菜单管理Controller Created by macro on 2020/2/4.
 */
@RestController
@Api(tags = "UmsMenuController", value = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {

    @Autowired
    private UmsMenuService menuService;

    @ApiOperation("添加后台菜单")
    @PostMapping("/create")
    public int create(@RequestBody UmsMenu umsMenu) {
        return menuService.create(umsMenu);
    }

    @ApiOperation("修改后台菜单")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id,
                      @RequestBody UmsMenu umsMenu) {
        return menuService.update(id, umsMenu);
    }

    @ApiOperation("根据ID获取菜单详情")
    @GetMapping("/{id}")
    public UmsMenu getItem(@PathVariable Long id) {
        return menuService.getItem(id);
    }

    @ApiOperation("根据ID删除后台菜单")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return menuService.delete(id);
    }

    @ApiOperation("分页查询后台菜单")
    @GetMapping("/list/{parentId}")
    public CommonPage<UmsMenu> list(@PathVariable Long parentId,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(menuService.list(parentId, pageSize, pageNum));
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @GetMapping("/treeList")
    public List<UmsMenuNode> treeList() {
        return menuService.treeList();
    }

    @ApiOperation("修改菜单显示状态")
    @PostMapping("/updateHidden/{id}")
    public int updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        return menuService.updateHidden(id, hidden);
    }
}

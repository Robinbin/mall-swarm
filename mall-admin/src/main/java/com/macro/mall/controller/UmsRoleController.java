package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.UmsMenu;
import com.macro.mall.model.UmsResource;
import com.macro.mall.model.UmsRole;
import com.macro.mall.service.UmsRoleService;
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
 * 后台用户角色管理 Created by macro on 2018/9/30.
 */
@RestController
@Api(tags = "UmsRoleController", value = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("添加角色")
    @PostMapping("/create")
    public int create(@RequestBody UmsRole role) {
        return roleService.create(role);
    }

    @ApiOperation("修改角色")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody UmsRole role) {
        return roleService.update(id, role);
    }

    @ApiOperation("批量删除角色")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return roleService.delete(ids);
    }

    @ApiOperation("获取所有角色")
    @GetMapping("/listAll")
    public List<UmsRole> listAll() {
        return roleService.list();
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @GetMapping("/list")
    public CommonPage<UmsRole> list(@RequestParam(value = "keyword", required = false) String keyword,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(roleService.list(keyword, pageSize, pageNum));
    }

    @ApiOperation("修改角色状态")
    @PostMapping("/updateStatus/{id}")
    public int updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setStatus(status);
        return roleService.update(id, umsRole);
    }

    @ApiOperation("获取角色相关菜单")
    @GetMapping("/listMenu/{roleId}")
    public List<UmsMenu> listMenu(@PathVariable Long roleId) {
        return roleService.listMenu(roleId);
    }

    @ApiOperation("获取角色相关资源")
    @GetMapping("/listResource/{roleId}")
    public List<UmsResource> listResource(@PathVariable Long roleId) {
        return roleService.listResource(roleId);
    }

    @ApiOperation("给角色分配菜单")
    @PostMapping("/allocMenu")
    public int allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        return roleService.allocMenu(roleId, menuIds);
    }

    @ApiOperation("给角色分配资源")
    @PostMapping("/allocResource")
    public int allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        return roleService.allocResource(roleId, resourceIds);
    }
}

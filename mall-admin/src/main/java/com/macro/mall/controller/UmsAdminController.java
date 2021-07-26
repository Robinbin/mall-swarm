package com.macro.mall.controller;

import cn.hutool.core.collection.CollUtil;
import com.macro.mall.common.annotation.SkipResponseBodyAdvice;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.domain.UserDto;
import com.macro.mall.dto.UmsAdminLoginParam;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.dto.UpdateAdminPasswordParam;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsRole;
import com.macro.mall.service.UmsAdminService;
import com.macro.mall.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 后台用户管理 Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "UmsAdminController", value = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public UmsAdmin register(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        return adminService.register(umsAdminParam);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        return adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/info")
    public Map<String, Object> getAdminInfo() {
        UmsAdmin umsAdmin = adminService.getCurrentAdmin();
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return data;
    }

    @ApiOperation(value = "登出功能")
    @PostMapping("/logout")
    public void logout() {

    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @GetMapping("/list")
    public CommonPage<UmsAdmin> list(@RequestParam(value = "keyword", required = false) String keyword,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(adminService.list(keyword, pageSize, pageNum));
    }

    @ApiOperation("获取指定用户信息")
    @GetMapping("/{id}")
    public UmsAdmin getItem(@PathVariable Long id) {
        return adminService.getItem(id);
    }

    @ApiOperation("修改指定用户信息")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        return adminService.update(id, admin);
    }

    @ApiOperation("修改指定用户密码")
    @PostMapping("/updatePassword")
    public CommonResult updatePassword(@RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除指定用户信息")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return adminService.delete(id);
    }

    @ApiOperation("修改帐号状态")
    @PostMapping("/updateStatus/{id}")
    public int updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        return adminService.update(id, umsAdmin);
    }

    @ApiOperation("给用户分配角色")
    @PostMapping("/role/update")
    public int updateRole(@RequestParam("adminId") Long adminId,
                          @RequestParam("roleIds") List<Long> roleIds) {
        return adminService.updateRole(adminId, roleIds);
    }

    @ApiOperation("获取指定用户的角色")
    @GetMapping("/role/{adminId}")
    public List<UmsRole> getRoleList(@PathVariable Long adminId) {
        return adminService.getRoleList(adminId);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @GetMapping("/loadByUsername")
    public @SkipResponseBodyAdvice
    UserDto loadUserByUsername(@RequestParam String username) {
        return adminService.loadUserByUsername(username);
    }
}

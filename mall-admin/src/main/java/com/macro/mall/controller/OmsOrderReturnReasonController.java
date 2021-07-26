package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.model.OmsOrderReturnReason;
import com.macro.mall.service.OmsOrderReturnReasonService;
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
 * 退货原因管理Controller Created by macro on 2018/10/17.
 */
@RestController
@Api(tags = "OmsOrderReturnReasonController", value = "退货原因管理")
@RequestMapping("/returnReason")
public class OmsOrderReturnReasonController {

    @Autowired
    private OmsOrderReturnReasonService orderReturnReasonService;

    @ApiOperation("添加退货原因")
    @PostMapping("/create")
    public int create(@RequestBody OmsOrderReturnReason returnReason) {
        return orderReturnReasonService.create(returnReason);
    }

    @ApiOperation("修改退货原因")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody OmsOrderReturnReason returnReason) {
        return orderReturnReasonService.update(id, returnReason);
    }

    @ApiOperation("批量删除退货原因")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return orderReturnReasonService.delete(ids);
    }

    @ApiOperation("分页查询全部退货原因")
    @GetMapping("/list")
    public CommonPage<OmsOrderReturnReason> list(
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(orderReturnReasonService.list(pageSize, pageNum));
    }

    @ApiOperation("获取单个退货原因详情信息")
    @GetMapping("/{id}")
    public OmsOrderReturnReason getItem(@PathVariable Long id) {
        return orderReturnReasonService.getItem(id);
    }

    @ApiOperation("修改退货原因启用状态")
    @PostMapping("/update/status")
    public int updateStatus(@RequestParam(value = "status") Integer status,
                            @RequestParam("ids") List<Long> ids) {
        return orderReturnReasonService.updateStatus(ids, status);
    }
}

package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.OmsOrderReturnApplyResult;
import com.macro.mall.dto.OmsReturnApplyQueryParam;
import com.macro.mall.dto.OmsUpdateStatusParam;
import com.macro.mall.model.OmsOrderReturnApply;
import com.macro.mall.service.OmsOrderReturnApplyService;
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
 * 订单退货申请管理 Created by macro on 2018/10/18.
 */
@RestController
@Api(tags = "OmsOrderReturnApplyController", value = "订单退货申请管理")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {

    @Autowired
    private OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("分页查询退货申请")
    @GetMapping("/list")
    public CommonPage<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(returnApplyService.list(queryParam, pageSize, pageNum));
    }

    @ApiOperation("批量删除申请")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return returnApplyService.delete(ids);
    }

    @ApiOperation("获取退货申请详情")
    @GetMapping("/{id}")
    public OmsOrderReturnApplyResult getItem(@PathVariable Long id) {
        return returnApplyService.getItem(id);
    }

    @ApiOperation("修改申请状态")
    @PostMapping("/update/status/{id}")
    public int updateStatus(@PathVariable Long id, @RequestBody OmsUpdateStatusParam statusParam) {
        return returnApplyService.updateStatus(id, statusParam);
    }
}

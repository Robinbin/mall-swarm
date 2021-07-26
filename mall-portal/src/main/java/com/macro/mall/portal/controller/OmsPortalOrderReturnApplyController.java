package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.OmsOrderReturnApplyParam;
import com.macro.mall.portal.service.OmsPortalOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 申请退货管理Controller Created by macro on 2018/10/17.
 */
@RestController
@Api(tags = "OmsPortalOrderReturnApplyController", value = "申请退货管理")
@RequestMapping("/returnApply")
public class OmsPortalOrderReturnApplyController {

    @Autowired
    private OmsPortalOrderReturnApplyService returnApplyService;

    @ApiOperation("申请退货")
    @PostMapping("/create")
    public int create(@RequestBody OmsOrderReturnApplyParam returnApply) {
        return returnApplyService.create(returnApply);
    }
}

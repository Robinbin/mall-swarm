package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * 订单管理Controller Created by macro on 2018/8/30.
 */
@RestController
@Api(tags = "OmsPortalOrderController", value = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {

    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车信息生成确认单信息")
    @PostMapping("/generateConfirmOrder")
    public ConfirmOrderResult generateConfirmOrder(@RequestBody List<Long> cartIds) {
        return portalOrderService.generateConfirmOrder(cartIds);
    }

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping("/generateOrder")
    public CommonResult generateOrder(@RequestBody OrderParam orderParam) {
        Map<String, Object> result = portalOrderService.generateOrder(orderParam);
        return CommonResult.success(result, "下单成功");
    }

    @ApiOperation("用户支付成功的回调")
    @PostMapping("/paySuccess")
    public CommonResult paySuccess(@RequestParam Long orderId, @RequestParam Integer payType) {
        Integer count = portalOrderService.paySuccess(orderId, payType);
        return CommonResult.success(count, "支付成功");
    }

    @ApiOperation("自动取消超时订单")
    @PostMapping("/cancelTimeOutOrder")
    public void cancelTimeOutOrder() {
        portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消单个超时订单")
    @PostMapping("/cancelOrder")
    public void cancelOrder(Long orderId) {
        portalOrderService.sendDelayMessageCancelOrder(orderId);
    }

    @ApiOperation("按状态分页获取用户订单列表")
    @ApiImplicitParam(name = "status", value = "订单状态：-1->全部；0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭",
        defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    @GetMapping("/list")
    public CommonPage<OmsOrderDetail> list(@RequestParam Integer status,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        return portalOrderService.list(status, pageNum, pageSize);
    }

    @ApiOperation("根据ID获取订单详情")
    @GetMapping("/detail/{orderId}")
    public OmsOrderDetail detail(@PathVariable Long orderId) {
        return portalOrderService.detail(orderId);
    }

    @ApiOperation("用户取消订单")
    @PostMapping("/cancelUserOrder")
    public void cancelUserOrder(Long orderId) {
        portalOrderService.cancelOrder(orderId);
    }

    @ApiOperation("用户确认收货")
    @PostMapping("/confirmReceiveOrder")
    public void confirmReceiveOrder(Long orderId) {
        portalOrderService.confirmReceiveOrder(orderId);
    }

    @ApiOperation("用户删除订单")
    @PostMapping("/deleteOrder")
    public void deleteOrder(Long orderId) {
        portalOrderService.deleteOrder(orderId);
    }
}

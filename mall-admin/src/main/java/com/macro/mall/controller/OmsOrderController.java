package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.OmsMoneyInfoParam;
import com.macro.mall.dto.OmsOrderDeliveryParam;
import com.macro.mall.dto.OmsOrderDetail;
import com.macro.mall.dto.OmsOrderQueryParam;
import com.macro.mall.dto.OmsReceiverInfoParam;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.service.OmsOrderService;
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
 * 订单管理Controller Created by macro on 2018/10/11.
 */
@RestController
@Api(tags = "OmsOrderController", value = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {

    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("查询订单")
    @GetMapping("/list")
    public CommonPage<OmsOrder> list(OmsOrderQueryParam queryParam,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(orderService.list(queryParam, pageSize, pageNum));
    }

    @ApiOperation("批量发货")
    @PostMapping("/update/delivery")
    public int delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        return orderService.delivery(deliveryParamList);
    }

    @ApiOperation("批量关闭订单")
    @PostMapping("/update/close")
    public int close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        return orderService.close(ids, note);
    }

    @ApiOperation("批量删除订单")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return orderService.delete(ids);
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @GetMapping("/{id}")
    public OmsOrderDetail detail(@PathVariable Long id) {
        return orderService.detail(id);
    }

    @ApiOperation("修改收货人信息")
    @PostMapping("/update/receiverInfo")
    public int updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        return orderService.updateReceiverInfo(receiverInfoParam);
    }

    @ApiOperation("修改订单费用信息")
    @PostMapping("/update/moneyInfo")
    public int updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        return orderService.updateMoneyInfo(moneyInfoParam);
    }

    @ApiOperation("备注订单")
    @PostMapping("/update/note")
    public int updateNote(@RequestParam("id") Long id,
                          @RequestParam("note") String note,
                          @RequestParam("status") Integer status) {
        return orderService.updateNote(id, note, status);
    }
}

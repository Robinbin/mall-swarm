package com.macro.mall.portal.controller;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartProduct;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.service.OmsCartItemService;
import com.macro.mall.portal.service.UmsMemberService;
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
 * 购物车管理Controller Created by macro on 2018/8/2.
 */
@RestController
@Api(tags = "OmsCartItemController", value = "购物车管理")
@RequestMapping("/cart")
public class OmsCartItemController {

    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("添加商品到购物车")
    @PostMapping("/add")
    public int add(@RequestBody OmsCartItem cartItem) {
        return cartItemService.add(cartItem);
    }

    @ApiOperation("获取某个会员的购物车列表")
    @GetMapping("/list")
    public List<OmsCartItem> list() {
        return cartItemService.list(memberService.getCurrentMember().getId());
    }

    @ApiOperation("获取某个会员的购物车列表,包括促销信息")
    @GetMapping("/list/promotion")
    public List<CartPromotionItem> listPromotion(@RequestParam(required = false) List<Long> cartIds) {
        return cartItemService.listPromotion(memberService.getCurrentMember().getId(), cartIds);
    }

    @ApiOperation("修改购物车中某个商品的数量")
    @GetMapping("/update/quantity")
    public int updateQuantity(@RequestParam Long id,
                              @RequestParam Integer quantity) {
        return cartItemService.updateQuantity(id, memberService.getCurrentMember().getId(), quantity);
    }

    @ApiOperation("获取购物车中某个商品的规格,用于重选规格")
    @GetMapping("/getProduct/{productId}")
    public CartProduct getCartProduct(@PathVariable Long productId) {
        return cartItemService.getCartProduct(productId);
    }

    @ApiOperation("修改购物车中商品的规格")
    @PostMapping("/update/attr")
    public int updateAttr(@RequestBody OmsCartItem cartItem) {
        return cartItemService.updateAttr(cartItem);
    }

    @ApiOperation("删除购物车中的某个商品")
    @PostMapping("/delete")
    public int delete(@RequestParam("ids") List<Long> ids) {
        return cartItemService.delete(memberService.getCurrentMember().getId(), ids);
    }

    @ApiOperation("清空购物车")
    @PostMapping("/clear")
    public int clear() {
        return cartItemService.clear(memberService.getCurrentMember().getId());
    }
}

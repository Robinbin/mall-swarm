package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.dto.PmsProductParam;
import com.macro.mall.dto.PmsProductQueryParam;
import com.macro.mall.dto.PmsProductResult;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.service.PmsProductService;
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
 * 商品管理Controller Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "PmsProductController", value = "商品管理")
@RequestMapping("/product")
public class PmsProductController {

    @Autowired
    private PmsProductService productService;

    @ApiOperation("创建商品")
    @PostMapping("/create")
    public int create(@RequestBody PmsProductParam productParam) {
        return productService.create(productParam);
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @GetMapping("/updateInfo/{id}")
    public PmsProductResult getUpdateInfo(@PathVariable Long id) {
        return productService.getUpdateInfo(id);
    }

    @ApiOperation("更新商品")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody PmsProductParam productParam) {
        return productService.update(id, productParam);
    }

    @ApiOperation("查询商品")
    @GetMapping("/list")
    public CommonPage<PmsProduct> getList(PmsProductQueryParam productQueryParam,
                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonPage.restPage(productService.list(productQueryParam, pageSize, pageNum));
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @GetMapping("/simpleList")
    public List<PmsProduct> getList(String keyword) {
        return productService.list(keyword);
    }

    @ApiOperation("批量修改审核状态")
    @PostMapping("/update/verifyStatus")
    public int updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("verifyStatus") Integer verifyStatus,
                                  @RequestParam("detail") String detail) {
        return productService.updateVerifyStatus(ids, verifyStatus, detail);
    }

    @ApiOperation("批量上下架")
    @PostMapping("/update/publishStatus")
    public int updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("publishStatus") Integer publishStatus) {
        return productService.updatePublishStatus(ids, publishStatus);
    }

    @ApiOperation("批量推荐商品")
    @PostMapping("/update/recommendStatus")
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("recommendStatus") Integer recommendStatus) {
        return productService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("批量设为新品")
    @PostMapping("/update/newStatus")
    public int updateNewStatus(@RequestParam("ids") List<Long> ids,
                               @RequestParam("newStatus") Integer newStatus) {
        return productService.updateNewStatus(ids, newStatus);
    }

    @ApiOperation("批量修改删除状态")
    @PostMapping("/update/deleteStatus")
    public int updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("deleteStatus") Integer deleteStatus) {
        return productService.updateDeleteStatus(ids, deleteStatus);
    }
}

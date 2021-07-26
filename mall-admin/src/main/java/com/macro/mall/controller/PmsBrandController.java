package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.PmsBrandParam;
import com.macro.mall.model.PmsBrand;
import com.macro.mall.service.PmsBrandService;
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

import java.util.List;

/**
 * 品牌功能Controller Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "PmsBrandController", value = "商品品牌管理")
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @GetMapping("/listAll")
    public CommonResult<List<PmsBrand>> getList() {
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation(value = "添加品牌")
    @PostMapping("/create")
    public int create(@Validated @RequestBody PmsBrandParam pmsBrand) {
        return brandService.createBrand(pmsBrand);
    }

    @ApiOperation(value = "更新品牌")
    @PostMapping("/update/{id}")
    public int update(@PathVariable("id") Long id,
                      @Validated @RequestBody PmsBrandParam pmsBrandParam) {
        return brandService.updateBrand(id, pmsBrandParam);
    }

    @ApiOperation(value = "删除品牌")
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return brandService.deleteBrand(id);
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @GetMapping("/list")
    public CommonPage<PmsBrand> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonPage.restPage(brandService.listBrand(keyword, pageNum, pageSize));
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @GetMapping("/{id}")
    public PmsBrand getItem(@PathVariable("id") Long id) {
        return brandService.getBrand(id);
    }

    @ApiOperation(value = "批量删除品牌")
    @PostMapping("/delete/batch")
    public int deleteBatch(@RequestParam("ids") List<Long> ids) {
        return brandService.deleteBrand(ids);
    }

    @ApiOperation(value = "批量更新显示状态")
    @PostMapping("/update/showStatus")
    public int updateShowStatus(@RequestParam("ids") List<Long> ids,
                                @RequestParam("showStatus") Integer showStatus) {
        return brandService.updateShowStatus(ids, showStatus);
    }

    @ApiOperation(value = "批量更新厂家制造商状态")
    @PostMapping("/update/factoryStatus")
    public int updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("factoryStatus") Integer factoryStatus) {
        return brandService.updateFactoryStatus(ids, factoryStatus);
    }
}

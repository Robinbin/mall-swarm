package com.macro.mall.controller;

import com.macro.mall.dto.SmsFlashPromotionSessionDetail;
import com.macro.mall.model.SmsFlashPromotionSession;
import com.macro.mall.service.SmsFlashPromotionSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 限时购场次管理Controller Created by macro on 2018/11/16.
 */
@RestController
@Api(tags = "SmsFlashPromotionSessionController", value = "限时购场次管理")
@RequestMapping("/flashSession")
public class SmsFlashPromotionSessionController {

    @Autowired
    private SmsFlashPromotionSessionService flashPromotionSessionService;

    @ApiOperation("添加场次")
    @PostMapping("/create")
    public int create(@RequestBody SmsFlashPromotionSession promotionSession) {
        return flashPromotionSessionService.create(promotionSession);
    }

    @ApiOperation("修改场次")
    @PostMapping("/update/{id}")
    public int update(@PathVariable Long id, @RequestBody SmsFlashPromotionSession promotionSession) {
        return flashPromotionSessionService.update(id, promotionSession);
    }

    @ApiOperation("修改启用状态")
    @PostMapping("/update/status/{id}")
    public int updateStatus(@PathVariable Long id, Integer status) {
        return flashPromotionSessionService.updateStatus(id, status);
    }

    @ApiOperation("删除场次")
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable Long id) {
        return flashPromotionSessionService.delete(id);
    }

    @ApiOperation("获取场次详情")
    @GetMapping("/{id}")
    public SmsFlashPromotionSession getItem(@PathVariable Long id) {
        return flashPromotionSessionService.getItem(id);
    }

    @ApiOperation("获取全部场次")
    @GetMapping("/list")
    public List<SmsFlashPromotionSession> list() {
        return flashPromotionSessionService.list();
    }

    @ApiOperation("获取全部可选场次及其数量")
    @GetMapping("/selectList")
    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        return flashPromotionSessionService.selectList(flashPromotionId);
    }
}
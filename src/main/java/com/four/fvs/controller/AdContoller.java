package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.Advertising;
import com.four.fvs.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hejiang
 * @Date: 2019/6/9
 * @Description:
 */
@RequestMapping("Advertising")
@Controller
public class AdContoller {
    @Autowired
    private AdService adService;

    /*
    * 遍历广告信息
    *
    * */
    @ResponseBody
    @RequestMapping("getAdvertising")
    public Result<Object> getAdvertising(){
        return ResultUtils.success(adService.getAdvertisingServicel());
    }
    /*
     * 添加广告
     *
     *
     * */
    @ResponseBody
    @RequestMapping("addAdvertising")
    public Result<Object> addAdvertising(Advertising advertising){
        adService.addAdvertisingServicel(advertising);
        return getAdvertising();
    }
    /*
     * 删除广告
     *
     * */
    @ResponseBody
    @RequestMapping("delAdvertising")
    public Result<Object> delAdvertising(@RequestParam("id")Integer id){
        adService.delAdvertisingServicel(id);
        return getAdvertising();
    }
    /*
     * 编辑广告
     *
     *
     * */
    @ResponseBody
    @RequestMapping("editAdvertising")
    public Result<Object> editAdvertising(Advertising advertising){
        adService.editAdvertisingServicel(advertising);
        return getAdvertising();
    }

}

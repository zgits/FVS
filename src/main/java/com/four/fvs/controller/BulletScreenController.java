package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.BulletScreen;
import com.four.fvs.service.BulletScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zjf
 * @Date: 2019/5/25 18:51
 * @Description:
 */

@Controller
@RequestMapping("/bulletScreen")
public class BulletScreenController {

    @Autowired
    private BulletScreenService bulletScreenService;


    /**
     * 发送弹幕,前台传递颜色代码时，要去掉#，
     * 不去掉#，相应的就为“”，暂时不知道原因
     * @param bulletScreen
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addBullet(BulletScreen bulletScreen){
        System.out.println(bulletScreen);
        return ResultUtils.success(bulletScreenService.addBulletScreen(bulletScreen));
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public Result<Object> getBullet(Integer videoId,Integer type){
        return ResultUtils.success(bulletScreenService.getBulletScreen(videoId, type));
    }
}

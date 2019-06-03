package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.service.VideoForHisPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 14:50.
 */
@Controller
@RequestMapping("/videoForHisPlay")
public class VideoForHisPlayController {


    @Autowired
    private VideoForHisPlayService videoForHisPlayService;


    @GetMapping("/getOne")
    @ResponseBody
    public Result<Object> getHisPlay(Integer id){
        return ResultUtils.success(videoForHisPlayService.getOneVideoById(id));
    }


    @GetMapping("/getTheSameInfo")
    @ResponseBody
    public Result<Object> getTheSameHisPlayInfo(Integer hisPlayId){
        return ResultUtils.success(videoForHisPlayService.getTheSameHisPlayInfo(hisPlayId));
    }
}

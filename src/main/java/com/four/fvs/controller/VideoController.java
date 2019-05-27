package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zjf
 * @Date: 2019/5/25 16:39
 * @Description:
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    @GetMapping(value = "/getVideo",params = {"id"})
    @ResponseBody
    public Result<Object> getVideo(Integer id){
        return ResultUtils.success(videoService.getOneVideoById(id));
    }


    @PatchMapping("/givePraise")
    @ResponseBody
    public Result<Object> givePraise(VideoOpRecord videoOpRecord){
        return ResultUtils.success(videoService.givePraise(videoOpRecord));
    }


    @PatchMapping("/giveCollection")
    @ResponseBody
    public Result<Object> giveCollection(VideoOpRecord videoOpRecord){
        return ResultUtils.success(videoService.giveCollection(videoOpRecord));
    }


    @PatchMapping("/giveShare")
    @ResponseBody
    public Result<Object> giveShare(VideoOpRecord videoOpRecord){
        return ResultUtils.success(videoService.giveShare(videoOpRecord));
    }

}

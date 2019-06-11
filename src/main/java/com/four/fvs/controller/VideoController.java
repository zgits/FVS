package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.service.VideoCommentService;
import com.four.fvs.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private VideoCommentService videoCommentService;


    @GetMapping(value = "/getVideo",params = {"id"})
    @ResponseBody
    public Result<Object> getVideo(Integer id){
        return ResultUtils.success(videoService.getOneVideoById(id));
    }


    @PatchMapping(value = "/updateVideovv/{id}")
    @ResponseBody
    public Result<Object> updateVideovv(@PathVariable("id") Integer id){
        return ResultUtils.success(videoService.updateVideovv(id));
    }

    @GetMapping(value = "/getCount",params={"id,type"})
    @ResponseBody
    public Result<Object>getCountById(Integer videoId,Integer type){
        return ResultUtils.success(videoCommentService.getCountById(videoId,type));
    }

    @PatchMapping("/givePraise")
    @ResponseBody
    public Result<Object> givePraise(@RequestBody VideoOpRecord videoOpRecord){
        return ResultUtils.success(videoService.givePraise(videoOpRecord));
    }


    @PatchMapping("/giveCollection")
    @ResponseBody
    public Result<Object> giveCollection(@RequestBody VideoOpRecord videoOpRecord){
        return ResultUtils.success(videoService.giveCollection(videoOpRecord));
    }


    @PatchMapping("/giveShare")
    @ResponseBody
    public Result<Object> giveShare(@RequestBody VideoOpRecord videoOpRecord){
        return ResultUtils.success(videoService.giveShare(videoOpRecord));
    }

    @GetMapping("/getAllVideo")
    @ResponseBody
    public  Result<Object> getAllVideo(){
        return ResultUtils.success(videoService.getAllVideo());
    }

    @GetMapping("/getTheSameVideo")
    @ResponseBody
    public Result<Object> getTheSameVideo(Integer userId,Integer type){
        return ResultUtils.success(videoService.getTheSameVideo(userId, type));
    }


    @GetMapping("/ifExistOp")
    @ResponseBody
    public Result<Object> ifExistOp(VideoOpRecord videoOpRecord){
        return ResultUtils.success(videoService.getIfExistOpRecord(videoOpRecord));
    }

}

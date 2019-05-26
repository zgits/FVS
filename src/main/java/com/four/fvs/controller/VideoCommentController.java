package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.VideoComment;
import com.four.fvs.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:23
 * @Description: 视频和番剧的评论
 */
@Controller
@RequestMapping("/videoComment")
public class VideoCommentController {

    @Autowired
    private VideoCommentService videoCommentService;

    @PostMapping("/addComment")
    @ResponseBody
    public Result<Object> addComment(VideoComment videoComment){

        return ResultUtils.success(videoCommentService.addComment(videoComment));
    }


    /**
     * 有一个问题，无法获得回复的用户信息，暂未解决 2019-5-25
     * @param currPage
     * @param videoId
     * @param type
     * @return
     */
    @GetMapping(value = "/getComment",params = {"videoId","type"})
    @ResponseBody
    public Result<Object> getComment(@RequestParam(defaultValue = "1") Integer currPage, Integer videoId, Integer type){
        return ResultUtils.success(videoCommentService.getCommentByPage(currPage, videoId, type));
    }


    @DeleteMapping(value = "/delComment",params = {"commentId"})
    @ResponseBody
    public Result<Object> delComment(Integer commentId){
        return ResultUtils.success(videoCommentService.delComment(commentId));
    }


}

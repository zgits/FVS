package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.VideoComment;
import com.four.fvs.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:23
 * @Description:
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
}

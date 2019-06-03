package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.CommentReply;
import com.four.fvs.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zjf
 * @Date: 2019/5/25 15:13
 * @Description: 回复的接口
 */
@Controller
@RequestMapping("/commentReply")
public class CommentReplyController {

    @Autowired
    private CommentReplyService commentReplyService;


    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addCommentReply(CommentReply commentReply){
        return ResultUtils.success(commentReplyService.addCommentReply(commentReply));
    }


    @DeleteMapping("/del")
    @ResponseBody
    public Result<Object> delCommentReply(Integer commentReplyId){
        //验证用户是否登录,再删除
        return ResultUtils.success(commentReplyService.delCommentReply(commentReplyId));
    }

    @GetMapping("/getUserReply")
    @ResponseBody
    public Result<Object> getUserCommentReply(@RequestParam(defaultValue = "1") Integer currPage,Integer userId){
        return ResultUtils.success(commentReplyService.getUserCommentReply(currPage,userId));
    }
}

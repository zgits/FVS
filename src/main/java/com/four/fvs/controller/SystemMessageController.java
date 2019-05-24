package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zjf
 * @Date: 2019/5/24 10:31
 * @Description:
 */
@Controller
@RequestMapping("/systemmessage")
public class SystemMessageController {

    @Autowired
    private SystemMessageService systemMessageService;


    /**
     * 用户版，得到系统通知消息接口
     * @param currPage
     * @param receiveId
     * @return
     */
    @GetMapping("/getMessage")
    @ResponseBody
    public Result<Object> getSystemMessage(@RequestParam(defaultValue = "1") Integer currPage, @RequestParam(value = "id") Integer receiveId){
        return ResultUtils.success(systemMessageService.getHistorySystemMessage(currPage,receiveId));
    }

}

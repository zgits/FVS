package com.four.fvs.controller;

import com.four.fvs.common.PageBean;
import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.SystemMessage;
import com.four.fvs.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result<Object> getSystemMessage(@RequestParam(defaultValue = "1") Integer currPage, @RequestParam(value = "userId") Integer receiveId){
        return ResultUtils.success(systemMessageService.getHistorySystemMessage(currPage,receiveId));
    }

    /**
     * 发送消息
     *
     * @param systemMessage 消息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> add(@RequestBody SystemMessage systemMessage){
        if (systemMessage != null) {
            int result = systemMessageService.insertSystemMessage(systemMessage);
            //当写完消息时，发送消息
            boolean flag = false;
            if(result > 0){
                systemMessageService.sendMes(systemMessage.getReceiveId(), systemMessage.getContent());
                flag = true;
            }
            return flag == true ? ResultUtils.success(result) : ResultUtils.serviceerror();
        }
        return ResultUtils.paramerror();
    }

    /**
     * 删除消息
     *
     * @param id 消息id
     * @return
     */
    @RequestMapping(value = "{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public Result<Object> delete(@PathVariable("id") Integer id){
        int result = systemMessageService.deleteMessage(id);
        return result > 0 ? ResultUtils.success(result) : ResultUtils.serviceerror();
    }

    /**
     * 展示消息
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Result<Object> query(){
        List<SystemMessage> lists = systemMessageService.listMessages();
        return lists == null ? ResultUtils.success(0) : ResultUtils.success(lists);
    }


}

package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.Video;
import com.four.fvs.model.WebStatus;
import com.four.fvs.service.WebStatusService;
import org.apache.ibatis.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author ljt
 * @Date 2019/5/31
 * @Description 查看网站情况controller
 */

@RequestMapping("admin/web")
@Controller
public class WebStatusController {

    @Autowired
    private WebStatusService webStatusService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> add(@RequestBody WebStatus webStatus){
        if (webStatus.getUserId() != null ) {
            int result = webStatusService.insertWebStatus(webStatus);
            return result > 0 ? ResultUtils.success(result) : ResultUtils.serviceerror();
        }
        return ResultUtils.paramerror();
    }

    @RequestMapping(value = "{startTime}/{type}" ,method = RequestMethod.GET)
    @ResponseBody
    public Result<Object> query(@PathVariable("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm") Date startTime,
                                    @PathVariable("type") Integer type){
        System.out.println("type is :"+type);
        System.out.println("time is :"+startTime);
        if(type == 1){
            int result = webStatusService.countVisitForWeek(startTime);
            return result >= 0 ? ResultUtils.success(result) : ResultUtils.serviceerror();
        }
        if(type == 2){
            int result = webStatusService.countVisitForTimeQuantum(startTime);
            return result >= 0 ? ResultUtils.success(result) : ResultUtils.serviceerror();
        }
        if(type == 3){
            List<Video> listRes = webStatusService.listTopVideoForVVs(startTime);
            return listRes != null ? ResultUtils.success(listRes) : ResultUtils.serviceerror();
        }
        else{
            return ResultUtils.paramerror();
        }
    }


}

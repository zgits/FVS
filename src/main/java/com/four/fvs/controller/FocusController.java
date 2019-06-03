package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.Focus;
import com.four.fvs.service.FocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 16:01.
 */
@Controller
@RequestMapping("/focus")
public class FocusController {


    @Autowired
    private FocusService focusService;


    @GetMapping("/getNumber")
    @ResponseBody
    public Result<Object> getNumber(Integer userId){
        return ResultUtils.success(focusService.getFocusNumber(userId));
    }

    @PostMapping("/addFocus")
    @ResponseBody
    public Result<Object> addFocus(Focus focus){
        return ResultUtils.success(focusService.addFocus(focus));
    }
}

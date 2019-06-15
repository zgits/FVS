package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.Focus;
import com.four.fvs.service.FocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @DeleteMapping("/delFocus")
    @ResponseBody
    public Result<Object> delFocus(@RequestBody Focus focus){
        System.out.println(focus);
        return ResultUtils.success(focusService.delFocus(focus));
    }


    @GetMapping("/ifExist")
    @ResponseBody
    public Result<Object> ifExist(Focus focus){
        return ResultUtils.success(focusService.ifExist(focus));
    }
}

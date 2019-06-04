package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hejiang
 * @Date: 2019/6/4 16:51
 * @Description:
 */
@Controller
@RequestMapping("Pass")
public class PassController {

    @Autowired
    private PassService passService;

    /**
     * 遍历审核通过视频信息
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("getPass")
    public Result<Object> getPass(){
        return ResultUtils.success(passService.getPassService());
    }
}

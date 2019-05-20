package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.Demo;
import com.four.fvs.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zjf
 * @Date: 2019/5/13 23:05
 * @Description:
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     *
     *
     * @param
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result<Object> add(Integer id) {
        Demo demo=new Demo();
        demo.setId(id);
        return ResultUtils.success(demoService.insert(demo));
    }
}

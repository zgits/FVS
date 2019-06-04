package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.User;
import com.four.fvs.service.UserService;
import com.four.fvs.service.VideoOpRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zjf
 * @Date: 2019/5/23 14:58
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private VideoOpRecordService videoOpRecordService;


    @PostMapping(value="/userlogin")
    @ResponseBody
    public Result<Object> login(String userName,String password){
        System.out.println("userName = [" + userName + "], password = [" + password + "]");
        User user=userService.login(userName, password);
        if(user!=null){
            /**
             * 登录成功
             */
           return ResultUtils.success(user);
        }else{
            /**
             * 登录失败
             */
            return ResultUtils.login_failed();
        }
    }


    @PostMapping(value = "/register")
    @ResponseBody
    public Result<Object> register(User user){
        System.out.println("user = " + user);
        if(userService.ifExist(user.getUserName())){
            return ResultUtils.username_exist();
        }
        return ResultUtils.success(userService.register(user));
    }


    @GetMapping(value = "/checkusername")
    @ResponseBody
    public Result<Object> checkUserName(String userName){
        if(userService.ifExist(userName)){
            return ResultUtils.username_exist();
        }
        return ResultUtils.success(null);
    }

    @GetMapping(value = "/getUserInfo")
    @ResponseBody
    public Result<Object> getUserInfo(Integer userId){
        return ResultUtils.success(userService.getUserInfo(userId));
    }



    @GetMapping(value = "/getPraiseInfo")
    @ResponseBody
    public Result<Object> getPraiseInfo(@RequestParam(defaultValue = "1") Integer currPage,Integer userId){
        return ResultUtils.success(videoOpRecordService.getUserPraise(currPage,userId));
    }

}

package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.User;
import com.four.fvs.service.UserService;
import com.four.fvs.service.VideoOpRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;

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
    public Result<Object> login(HttpServletRequest request, String userName, String password){
        System.out.println("userName = [" + userName + "], password = [" + password + "]");
        User user=userService.login(userName, password);
        if(user!=null){

            /**
             * 登录成功
             * 记录用户名，方便做在线人数登记
             */
            HttpSession session = request.getSession();
            session.setAttribute("nickname",userName);
            return ResultUtils.success(user);
        }else{
            /**
             * 登录失败
             */
            return ResultUtils.login_failed();
        }
    }

    /**
     * 当用户注销时，手动删除session
     *
     * @param request
     * @return
     */
    @PostMapping(value="/loginOut")
    @ResponseBody
    public Result<Object> loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        //在线人数减1
        Integer lineCount = (Integer) context.getAttribute("linecount");
        context.setAttribute("linecount",lineCount-1);
        //移除session
        HashSet<HttpSession> httpSessions = (HashSet<HttpSession>) context.getAttribute("sessionHashSet");
        if (httpSessions != null){
            httpSessions.remove(session);
            return ResultUtils.success(1);
        }
        return ResultUtils.serviceerror();
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

    @PostMapping(value = "/editxx")
    @ResponseBody
    public Result<Object> editxx(User user){
        return ResultUtils.success(userService.editxx(user));
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

    /**
     * @Author: yzh
     * @Date: 2019/6/8 16:32
     * @Description: 用户信息的管理
     */

    /**
     * 遍历所有的用户信息
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/getAllUser")
    public Result<Object> getAllUser(){
        return ResultUtils.success(userService.getAllUserService());
    }

    /**
     * 得到某个用户的信息
     * @param
     * @return
     */

    @ResponseBody
    @GetMapping(value = "/getUser")
    public Result<Object> getUser(Integer id){

        return ResultUtils.success(userService.getUserService(id));
    }
    /**
     * @Author: DWH
     * @Date: 2019/6/12
     * @Description: 查找粉丝
     */

    /**
     * 得到某个用户的所有粉丝信息
     * @param
     * @return
     */

    @ResponseBody
    @GetMapping(value = "/getFans")
    public Result<Object> getFans(Integer userId){
        return ResultUtils.success(userService.getFansService(userId));

    }
    /**
     * 得到某个用户的所有关注人信息
     * @param
     * @return
     */

    @ResponseBody
    @GetMapping(value = "/getFocus")
    public Result<Object> getFocus(Integer userId){
        return ResultUtils.success(userService.getFocusService(userId));

    }



}

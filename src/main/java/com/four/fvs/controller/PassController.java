package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.Video;
import com.four.fvs.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 删除视频
     * @RequestParam("id"):获取选中视频id
     * @return
     *
     */
    @ResponseBody
    @GetMapping("delVideo")
    public Result<Object> delVideo(@RequestParam("id")Integer videoId){
        passService.delVideoService(videoId);
        return getPass();
    }

    /*
     * 查询指定审核通过的视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    @ResponseBody
    @GetMapping("getOnePassAuditing")
    public Result<Object> getOnePassAuditing(@RequestParam("id")Integer id){
        return ResultUtils.success(passService.searchPassServicel(id));
    }

    /*
     * 编辑视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    @ResponseBody
    @GetMapping("editPassAuditing")
    public Result<Object> editPassAuditing(Video video){
        passService.editVideoServicel(video);
        System.out.println(video.toString());
        return getPass();
    }
}

package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.HisPlay;
import com.four.fvs.model.VideoForHisPlay;
import com.four.fvs.service.UploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hejiang
 * @Date: 2019/6/6 10:51
 * @Controller 标记一个类是Controller
 * @Description:
 */

@RequestMapping("upload")
@Controller
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 遍历番剧HisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    @ResponseBody
    @GetMapping("getUpload")
    public Result<Object> getUpload(){
        return ResultUtils.success(uploadService.getUploadServicel());
    }

    /**
     * 获取指定番剧HisPlay信息,编辑的时候用
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    @ResponseBody
    @RequestMapping("getDesignateHisPlay")
    public Result<Object> getDesignateHisPlay(@RequestParam("id")Integer id){
        return ResultUtils.success(uploadService.getDesignateServicel(id));
    }

    /**
     * 修改番剧信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    @ResponseBody
    @RequestMapping("editUpload")
    public Result<Object> editUpload(HisPlay hisply){
        uploadService.editUploadServicel(hisply);
        return getUpload();
    }

    /**
     * 添加番剧HisPlay信息
     * @param
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("addHisPlay")
    public Result<Object> addHisPlay(@RequestParam("name")String name, @RequestParam("playNumber")Integer playNumber,
                                     @RequestParam("introduce") String introduce){
        uploadService.addHisPlayServicel(name, playNumber, introduce);
        return getUpload();
    }
    /**
     * 删除番剧HisPlay信息
     * @param
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("delHisPlay")
    public Result<Object> delHisPlay(@RequestParam("id")Integer id){
        uploadService.delHisPlayServicel(id);
        return getUpload();
    }

    /**
     * 遍历指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    @ResponseBody
    @RequestMapping("getVideoForHisPlay")
    public Result<Object> getVideoForHisPlay(@RequestParam("id") Integer id){
        return ResultUtils.success(uploadService.getVideoForHisPlayl(id));
    }

    /**
     * 添加番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("addVideoForHisPlay")
    public Result<Object> addVideoForHisPlay(VideoForHisPlay videoForHisPlay){
        uploadService.addVideoForHisPlayl(videoForHisPlay);
        return  getVideoForHisPlay(videoForHisPlay.getHisPlayId());
    }
    /**
     * 修改指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("editVideoForHisPlay")
    public Result<Object> editVideoForHisPlay(VideoForHisPlay videoForHisPlay){
        uploadService.editVideoForHisPlayServicel(videoForHisPlay);
        return getVideoForHisPlay(videoForHisPlay.getHisPlayId());
    }
    /**
     * 删除指定番剧视频VideoForHisPlay
     * @param
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("delVideoForHisPlay")
    public Result<Object> delVideoForHisPlay(@RequestParam("id")Integer id, @RequestParam("hisPlayId") Integer hisPlayId){
        uploadService.deldelVideoForHisPlayServicel(id);
        return getVideoForHisPlay(hisPlayId);
    }
}

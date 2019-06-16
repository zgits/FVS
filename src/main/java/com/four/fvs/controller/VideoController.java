package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.service.TypeService;
import com.four.fvs.service.VideoCommentService;
import com.four.fvs.service.VideoService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/25 16:39
 * @Description:
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private VideoCommentService videoCommentService;
    @Autowired
    private TypeService typeService;

    @GetMapping(value = "/getVideo", params = {"id"})
    @ResponseBody
    public Result<Object> getVideo(Integer id) {
        return ResultUtils.success(videoService.getOneVideoById(id));
    }


    @PatchMapping(value = "/updateVideovv/{id}")
    @ResponseBody
    public Result<Object> updateVideovv(@PathVariable("id") Integer id) {
        return ResultUtils.success(videoService.updateVideovv(id));
    }

    @GetMapping(value = "/getCount", params = {"id,type"})
    @ResponseBody
    public Result<Object> getCountById(Integer videoId, Integer type) {
        return ResultUtils.success(videoCommentService.getCountById(videoId, type));
    }

    @PatchMapping("/givePraise")
    @ResponseBody
    public Result<Object> givePraise(@RequestBody VideoOpRecord videoOpRecord) {
        return ResultUtils.success(videoService.givePraise(videoOpRecord));
    }


    @PatchMapping("/giveCollection")
    @ResponseBody
    public Result<Object> giveCollection(@RequestBody VideoOpRecord videoOpRecord) {
        return ResultUtils.success(videoService.giveCollection(videoOpRecord));
    }


    @PatchMapping("/giveShare")
    @ResponseBody
    public Result<Object> giveShare(@RequestBody VideoOpRecord videoOpRecord) {
        return ResultUtils.success(videoService.giveShare(videoOpRecord));
    }

    /**
     * 首页视频获取
     * @return
     */
    @GetMapping("/getAllVideo")
    @ResponseBody
    public Result<Object> getAllVideo() {
        return ResultUtils.success(videoService.getAllVideo());
    }

    /**
     * 根据分区id获取分区名称
     * @param typeId
     * @return
     */
    @GetMapping(value = "/getTypeName")
    @ResponseBody
    public Result<Object> getTypeName(Integer typeId)
    {return ResultUtils.success(typeService.getTypeName(typeId));}

    /**
     * 获取全部类型
     * @return
     */
    @GetMapping(value="/getAllType")
    @ResponseBody
    public Result<Object> getAllType(){
        return ResultUtils.success(typeService.getAllType());
    }

    /**
     * 首页各分区排行榜
     * @param typeId
     * @return
     */
    @GetMapping(value = "/getVideoRank")
    @ResponseBody
    public Result<Object> getVieoRank(Integer typeId){return  ResultUtils.success(videoService.getVideoRank(typeId));}

    /**
     * 头部各分区视频数量
     * @return
     */
    @GetMapping(value = "/getAllCount")
    @ResponseBody
    public Result<Object> getAllCount(){return ResultUtils.success(videoService.getAllCount());}

    /**
     * 各分区全部视频信息
     * @param typeId
     * @return
     */
    @GetMapping(value="/getVideoByType")
    @ResponseBody
    public Result<Object> getVideoByType(@RequestParam(defaultValue = "1") Integer currPage,Integer typeId){
        return  ResultUtils.success(videoService.getVideoByType(currPage,typeId));
    }

    /**
     * 根据名称模糊查询视频
     * @param name
     * @return
     */
    @GetMapping("/getVideoByName")
    @ResponseBody
    public Result<Object>getVideoByName(@RequestParam(defaultValue = "1") Integer currPage,String name) throws Exception{
        return ResultUtils.success(videoService.getVideoByName(currPage,name));
    }

    /**
     * 根据名称模糊查询用户
     */
    @GetMapping("/getUserByName")
    @ResponseBody
    public Result<Object>getUserByName(@RequestParam(defaultValue = "1") Integer currPage,String name){
        return ResultUtils.success(videoService.getUserByName(currPage,name));
    }

    /**
     * 获取更新数量
     * @param typeId
     * @return
     */
    @GetMapping("/getUpdateCount")
    @ResponseBody
    public Result<Object>getUpdateCount(Integer typeId){
        return ResultUtils.success(videoService.getUpdateCount(typeId));
    }


    @GetMapping("/getTheSameVideo")
    @ResponseBody
    public Result<Object> getTheSameVideo(Integer userId, Integer type) {
        return ResultUtils.success(videoService.getTheSameVideo(userId, type));
    }


    @GetMapping("/ifExistOp")
    @ResponseBody
    public Result<Object> ifExistOp(VideoOpRecord videoOpRecord) {
        return ResultUtils.success(videoService.getIfExistOpRecord(videoOpRecord));
    }


    @PostMapping("/upload")
    @ResponseBody
    public Result<Object> upload(MultipartFile file, HttpServletRequest request) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String fileBaseName = FilenameUtils.getBaseName(originalFilename);
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String contexPath = request.getSession().getServletContext().getRealPath("/");
        String floderName = fileBaseName + "_" + df.format(now);
        System.out.println(contexPath+"video/");
        //创建要上传的路径
        File fdir = new File(contexPath + "video/");
        if (!fdir.exists()) {
            fdir.mkdirs();
        }
        //文件上传到路径下
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(fdir, originalFilename));
        return ResultUtils.success("success");
    }


    /**
     * 遍历CollectVideo信息
     *
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getCollectVideo")
    public Result<Object> getCollectVideo(Integer userId) {
        return ResultUtils.success(videoService.getCollectVideoService(userId));
    }

    /**
     * 遍历收藏的视频信息
     *
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getShoucangVideo")
    public Result<Object> getShoucangVideo(Integer userId) {
        return ResultUtils.success(videoService.getShoucangVideoService(userId));
    }
}

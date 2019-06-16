package com.four.fvs.controller;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.model.VideoOpRecord;
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

    @GetMapping("/getAllVideo")
    @ResponseBody
    public Result<Object> getAllVideo() {
        return ResultUtils.success(videoService.getAllVideo());
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

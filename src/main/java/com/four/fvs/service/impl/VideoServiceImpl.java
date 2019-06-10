package com.four.fvs.service.impl;

import com.four.fvs.dao.VideoDao;
import com.four.fvs.dao.VideoOpRecordDao;
import com.four.fvs.model.User;
import com.four.fvs.model.Video;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.service.FocusService;
import com.four.fvs.service.TypeService;
import com.four.fvs.service.UserService;
import com.four.fvs.service.VideoService;
import com.four.fvs.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 16:38
 * @Description:
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Autowired
    private VideoOpRecordDao videoOpRecordDao;


    @Autowired
    private UserService userService;


    @Autowired
    private FocusService focusService;

    @Autowired
    private TypeService typeService;


    @Override
    public VideoVo getOneVideoById(Integer videoId) {

        Video video=videoDao.getOneVideoById(videoId);
        VideoVo videoVo=new VideoVo();
        User user=userService.getUserInfo(video.getUserId());
        videoVo.setVideo(video);
        videoVo.setFocus(focusService.getFocusNumber(video.getUserId()));

        videoVo.setUserName(user.getUserName());
        videoVo.setIcon(user.getIcon());
        videoVo.setUserId(user.getId());
        videoVo.setType(typeService.getTypeName(video.getTypeId()));
        return videoVo;
    }

    @Override
    public boolean givePraise(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(1);
        videoOpRecord.setTime(new Date());
        VideoOpRecord videoOpRecord1=videoOpRecordDao.getRecord(videoOpRecord);
        System.out.println(videoOpRecord1);
        int number=videoOpRecord1!=null?-1:1;
        if(videoOpRecord1!=null){
            videoOpRecordDao.delRecord(videoOpRecord);
        }else{
            videoOpRecordDao.addRecord(videoOpRecord);
        }
        return videoDao.givePraise(videoOpRecord.getVideoId(),number)>0;
    }

    @Override
    public boolean giveShare(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(2);
        videoOpRecord.setTime(new Date());
        videoOpRecordDao.addRecord(videoOpRecord);
        return videoDao.giveShare(videoOpRecord.getVideoId())>0;
    }

    /**
     * 还要加上用户的实际收藏操作
     * @param videoOpRecord
     * @return
     */
    @Override
    public boolean giveCollection(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(3);
        videoOpRecord.setTime(new Date());
        VideoOpRecord videoOpRecord1=videoOpRecordDao.getRecord(videoOpRecord);
        System.out.println(videoOpRecord1);
        if(videoOpRecord1!=null){
            videoOpRecordDao.delRecord(videoOpRecord);
        }else{
            videoOpRecordDao.addRecord(videoOpRecord);
        }
        int number=videoOpRecord1!=null?-1:1;
        return videoDao.giveCollection(videoOpRecord.getVideoId(),number)>0;
    }

    @Override
    public List<VideoVo> getTheSameVideo(Integer userId, Integer type) {
        List<Video> videos=videoDao.getTheSameVideo(userId,type);

        List<VideoVo> result=new ArrayList<>();
        VideoVo videoVo;
        for (Video video : videos) {
            User user=userService.getUserInfo(video.getUserId());
            videoVo=new VideoVo();
            videoVo.setVideo(video);
            videoVo.setIcon(user.getIcon());
            videoVo.setUserId(user.getId());
            videoVo.setUserName(user.getUserName());
            result.add(videoVo);
        }
        return result;

    }
}

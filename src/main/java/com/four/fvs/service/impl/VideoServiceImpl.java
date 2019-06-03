package com.four.fvs.service.impl;

import com.four.fvs.dao.VideoDao;
import com.four.fvs.dao.VideoOpRecordDao;
import com.four.fvs.model.Video;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public Video getOneVideoById(Integer videoId) {
        return videoDao.getOneVideoById(videoId);
    }

    @Override
    public boolean givePraise(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(1);
        VideoOpRecord videoOpRecord1=videoOpRecordDao.getRecord(videoOpRecord);
        System.out.println(videoOpRecord1);
        int number=videoOpRecord1!=null?-1:1;
        if(videoOpRecord1!=null){
            videoOpRecordDao.delRecord(videoOpRecord);
        }else{
            videoOpRecordDao.addRecord(videoOpRecord);
        }
        return videoDao.givePraise(videoOpRecord.getRecordId(),number)>0;
    }

    @Override
    public boolean giveShare(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(2);
        videoOpRecordDao.addRecord(videoOpRecord);
        return videoDao.giveShare(videoOpRecord.getRecordId())>0;
    }

    /**
     * 还要加上用户的实际收藏操作
     * @param videoOpRecord
     * @return
     */
    @Override
    public boolean giveCollection(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(3);
        VideoOpRecord videoOpRecord1=videoOpRecordDao.getRecord(videoOpRecord);
        System.out.println(videoOpRecord1);
        if(videoOpRecord1!=null){
            videoOpRecordDao.delRecord(videoOpRecord);
        }else{
            videoOpRecordDao.addRecord(videoOpRecord);
        }
        int number=videoOpRecord1!=null?-1:1;
        return videoDao.giveCollection(videoOpRecord.getRecordId(),number)>0;
    }
}

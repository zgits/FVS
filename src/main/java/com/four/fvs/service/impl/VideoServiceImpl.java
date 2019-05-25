package com.four.fvs.service.impl;

import com.four.fvs.dao.VideoDao;
import com.four.fvs.model.Video;
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

    @Override
    public Video getOneVideoById(Integer videoId) {
        return videoDao.getOneVideoById(videoId);
    }
}

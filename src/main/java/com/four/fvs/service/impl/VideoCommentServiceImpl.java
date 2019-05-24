package com.four.fvs.service.impl;

import com.four.fvs.dao.VideoCommentDao;
import com.four.fvs.model.VideoComment;
import com.four.fvs.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:19
 * @Description:
 */
@Service
public class VideoCommentServiceImpl implements VideoCommentService {


    @Autowired
    private VideoCommentDao videoCommentDao;

    @Override
    public Integer addComment(VideoComment videoComment) {

        videoComment.setCreateTime(new Date());
        videoComment.setPraiseNumber(0);
        return videoCommentDao.insert(videoComment);
    }
}

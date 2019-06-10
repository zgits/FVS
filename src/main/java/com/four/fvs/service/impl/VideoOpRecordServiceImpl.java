package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.VideoOpRecordDao;
import com.four.fvs.model.User;
import com.four.fvs.model.VideoComment;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.service.UserService;
import com.four.fvs.service.VideoCommentService;
import com.four.fvs.service.VideoOpRecordService;
import com.four.fvs.vo.OpRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/6/4 20:21
 * @Description:
 */
@Service
public class VideoOpRecordServiceImpl implements VideoOpRecordService {


    @Autowired
    private VideoOpRecordDao videoOpRecordDao;

    @Autowired
    private UserService userService;

    @Autowired
    private VideoCommentService videoCommentService;

    @Override
    public PageBean<OpRecordVo> getUserPraise(Integer currPage, Integer userId) {


        PageBean<OpRecordVo> result=new PageBean<>();

        Integer size = 0;
        Integer begin = 0;
        if (currPage == 1) {
            size = 8;
        } else if (currPage == 2) {
            /**
             * 第二次下拉加载时，直接开始设置为20，
             */
            begin = 8;
            size = 10;
        } else {
            size = 10;
            begin = (currPage - 1) * size;
        }

        List<VideoOpRecord> videoOpRecords=videoOpRecordDao.getUserPraise(userId,begin,size);

        List<OpRecordVo> opRecordVos=new ArrayList<>();

        OpRecordVo opRecordVo;
        for (VideoOpRecord videoOpRecord : videoOpRecords) {

            opRecordVo=new OpRecordVo();

            User user = userService.getUserInfo(videoOpRecord.getUserId());

            opRecordVo.setIcon(user.getIcon());

            opRecordVo.setTime(videoOpRecord.getTime());

            opRecordVo.setUserId(videoOpRecord.getUserId());

            opRecordVo.setUserName(user.getUserName());


            VideoComment videoComment=videoCommentService.getOneCommentById(videoOpRecord.getCommentId());

            opRecordVo.setComment(videoComment.getContent());

            opRecordVo.setCommentId(videoComment.getId());

            opRecordVos.add(opRecordVo);

        }

        result.setCurrPage(currPage);

        result.setLists(opRecordVos);
        return result;
    }
}

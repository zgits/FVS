package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.VideoCommentDao;
import com.four.fvs.model.User;
import com.four.fvs.model.VideoComment;
import com.four.fvs.service.UserService;
import com.four.fvs.service.VideoCommentService;
import com.four.fvs.vo.VideoCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:19
 * @Description:
 */
@Service
public class VideoCommentServiceImpl implements VideoCommentService {


    @Autowired
    private VideoCommentDao videoCommentDao;

    @Autowired
    private UserService userService;

    @Override
    public Integer addComment(VideoComment videoComment) {

        videoComment.setCreateTime(new Date());
        videoComment.setPraiseNumber(0);
        videoComment.setDel(1);
        return videoCommentDao.insert(videoComment);
    }

    @Override
    public PageBean<VideoCommentVo> getCommentByPage(Integer currPage, Integer videoId, Integer type) {

        PageBean<VideoCommentVo> result=new PageBean<>();

        Integer size=10;//设置默认显示10条
        Integer count=videoCommentDao.getCount(videoId,type);
        result.setCurrPage(currPage);
        result.setTotalCount(count);
        result.setPageSize(size);
        Integer begin=(currPage-1)*10;
        double tc=count;
        Double pageCount=Math.ceil(tc/size);
        result.setTotalPage(pageCount.intValue());

        List<VideoComment> videoComments=videoCommentDao.getVideoComment(videoId,begin,size,type);

        List<VideoCommentVo> videoCommentVos=new ArrayList<>();

        VideoCommentVo videoCommentVo;

        for (VideoComment videoComment : videoComments) {
            videoCommentVo=new VideoCommentVo();
            videoCommentVo.setVideoComment(videoComment);
            User user=userService.getUserInfo(videoComment.getUserId());
            videoCommentVo.setIcon(user.getIcon());//设置该条评论用户的头像地址
            videoCommentVo.setUserId(user.getId());
            videoCommentVo.setUserName(user.getUserName());
            videoCommentVo.setReplyNumber(videoComment.getCommentReplyList().size());//设置该条评论的回复数量
            videoCommentVos.add(videoCommentVo);
        }
        result.setLists(videoCommentVos);
        return result;
    }

    @Override
    public boolean delComment(Integer commentId) {
        return videoCommentDao.delComment(commentId)>0;
    }
}
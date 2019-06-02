package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.CommentReplyDao;
import com.four.fvs.model.CommentReply;
import com.four.fvs.model.User;
import com.four.fvs.service.CommentReplyService;
import com.four.fvs.service.UserService;
import com.four.fvs.vo.CommentReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 15:11
 * @Description:
 */
@Service
public class CommentReplyServiceImpl implements CommentReplyService {

    @Autowired
    private CommentReplyDao commentReplyDao;


    @Autowired
    private UserService userService;


    @Override
    public boolean addCommentReply(CommentReply commentReply) {
        commentReply.setReplyTime(new Date());
        commentReply.setDel(1);
        return commentReplyDao.addCommentReply(commentReply) > 0;
    }

    @Override
    public boolean delCommentReply(Integer commentReplyId) {
        return commentReplyDao.delCommentReply(commentReplyId) > 0;
    }

    @Override
    public List<CommentReply> getCommentReply(Integer commentId) {
        return commentReplyDao.getCommentReply(commentId);
    }

    @Override
    public PageBean<CommentReplyVo> getUserCommentReply(Integer currPage, Integer beReplyId) {


        Integer size = 0;
        Integer begin = 0;
        if (currPage == 1) {
            size = 20;
        } else if (currPage == 2) {
            /**
             * 第二次下拉加载时，直接开始设置为20，
             */
            begin = 20;
            size = 10;
        } else {
            size = 10;
            begin = (currPage - 1) * size;
        }


        PageBean<CommentReplyVo> result = new PageBean<>();

        result.setCurrPage(currPage);

        List<CommentReply> commentReplies = commentReplyDao.getUserCommentReply(beReplyId, begin, size);


        List<CommentReplyVo> commentReplyVos = new ArrayList<>();

        CommentReplyVo commentReplyVo;
        for (CommentReply commentReply : commentReplies) {
            commentReplyVo = new CommentReplyVo();

            commentReplyVo.setCommentReply(commentReply);

            //根据回复id获取回复人的信息
            User user = userService.getUserInfo(commentReply.getReplyId());

            commentReplyVo.setIcon(user.getIcon());

            commentReplyVo.setUserName(user.getUserName());

            commentReplyVo.setUserId(user.getId());

            //end

            //设置被回复人的信息，用户在点击自己的消息中心时的自己信息
            User user1=userService.getUserInfo(commentReply.getBeReplyId());

            commentReplyVo.setBeIcon(user1.getIcon());

            commentReplyVo.setBeUserId(user1.getId());

            commentReplyVo.setBeUserName(user1.getUserName());

            commentReplyVos.add(commentReplyVo);

        }

        result.setLists(commentReplyVos);

        return result;
    }
}

package com.four.fvs.service.impl;

import com.four.fvs.dao.CommentReplyDao;
import com.four.fvs.model.CommentReply;
import com.four.fvs.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean addCommentReply(CommentReply commentReply) {
        commentReply.setReplyTime(new Date());
        commentReply.setDel(1);
        return commentReplyDao.addCommentReply(commentReply)>0;
    }

    @Override
    public boolean delCommentReply(Integer commentReplyId) {
        return commentReplyDao.delCommentReply(commentReplyId)>0;
    }

    @Override
    public List<CommentReply> getCommentReply(Integer commentId) {
        return commentReplyDao.getCommentReply(commentId);
    }
}

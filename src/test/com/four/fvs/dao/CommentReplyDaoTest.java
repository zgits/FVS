package com.four.fvs.dao;

import com.four.fvs.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: zjf
 * @Date: 2019/6/1 14:12
 * @Description:
 */
public class CommentReplyDaoTest extends BaseTest {

    @Autowired
    private CommentReplyDao commentReplyDao;
    @Test
    public void getUserCommentReply() {

        //System.out.println(commentReplyDao.getUserCommentReply(3));
    }
}
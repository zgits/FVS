package com.four.fvs.dao;

import com.four.fvs.model.VideoComment;
import org.springframework.stereotype.Repository;

/**
 * @Author: zjf
 * @Date: 2019/5/24 12:04
 * @Description: 视频评论数据库接口
 */
@Repository
public interface VideoCommentDao {


    /**
     * 插入评论
     * @param videoComment
     * @return
     */
    public Integer insert(VideoComment videoComment);

//
//    /**
//     * 由于字段缺失，暂不填写参数
//     * @return
//     */
//    public Integer praise();


}

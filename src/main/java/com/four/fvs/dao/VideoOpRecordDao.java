package com.four.fvs.dao;

import com.four.fvs.model.VideoOpRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: zjf
 * @Date: 2019/5/25 22:00
 * @Description: 用户有关视频或者番剧的操作记录，点赞，分享，对评论的点赞 数据库接口
 */
@Repository
public interface VideoOpRecordDao {


    /**
     * 增加操作记录
     * @param videoOpRecord
     * @return
     */
    public Integer addRecord(VideoOpRecord videoOpRecord);


    /**
     * 查询操作记录
     * @param videoOpRecord
     * @return
     */
    public VideoOpRecord getRecord(VideoOpRecord videoOpRecord);


    /**
     * 取消某个点赞或者收藏，删除对应的操作记录
     * @param videoOpRecord
     * @return
     */
    public Integer delRecord(VideoOpRecord videoOpRecord);
}

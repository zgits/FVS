package com.four.fvs.service;

import com.four.fvs.model.Video;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.vo.VideoIndexVo;
import com.four.fvs.vo.VideoVo;

import java.util.List;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 16:37
 * @Description: 视频的服务接口
 */
public interface VideoService {

    /**
     * 根据id获取视频数据
     * @param videoId
     * @return
     */
    public VideoVo getOneVideoById(Integer videoId);


    /**
     * 增加视频播放量
     * @param id
     * @return
     */
    public Integer updateVideovv(Integer id);


    /**
     *判断之前是否已点赞来决定赞数的加减
     * 所需参数 userId，recordId，type，opType
     * @param videoOpRecord
     * @return
     */
    public boolean givePraise(VideoOpRecord videoOpRecord);

    /**
     *记录分享的操作记录,分享数+1
     * @param videoOpRecord
     * @return
     */
    public boolean giveShare(VideoOpRecord videoOpRecord);


    /**
     * 判断之前是否已收藏过来决定收藏数的加减，s
     * 收藏操作还要加上，用户方面的收藏夹
     * @param videoOpRecord
     * @return
     */
    public boolean giveCollection(VideoOpRecord videoOpRecord);

    /**
     *获取首页视频信息
     * @return
     */
    public List<VideoIndexVo> getAllVideo();


    /**
     *得到相同类型的视频信息
     * @param userId
     * @param type
     * @return
     */
    public List<VideoVo> getTheSameVideo(Integer userId,Integer type);


    /**
     * 查询某个操作记录是否存在
     * @param videoOpRecord
     * @return
     */
    public boolean getIfExistOpRecord(VideoOpRecord videoOpRecord);
}

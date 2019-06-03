package com.four.fvs.service;

import com.four.fvs.model.VideoForHisPlay;

import java.util.List;

/**
 * @Description: 番剧的service接口
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 14:48.
 */
public interface VideoForHisPlayService {

    /**
     * 根据id获取某个番剧视频及信息
     * @param id
     * @return
     */
    public VideoForHisPlay getOneVideoById(Integer id);


    /**
     * 根据番剧id查询同属某个番剧的视频的基本信息
     * @param hisPlayId
     * @return
     */
    public List<VideoForHisPlay> getTheSameHisPlayInfo(Integer hisPlayId);
}

package com.four.fvs.service;

import com.four.fvs.model.Video;

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
    public Video getOneVideoById(Integer videoId);
}

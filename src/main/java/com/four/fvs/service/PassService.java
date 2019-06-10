package com.four.fvs.service;

import com.four.fvs.model.Video;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/4 16:51
 * @Description:
 */
public interface PassService {

    /**
     * 遍历审核通过视频信息
     * @param
     * @return
     */
    public List<Video> getPassService();

    /**
     * 删除视频
     * @param
     * @return
     */
    public boolean delVideoService(Integer videoId);
}
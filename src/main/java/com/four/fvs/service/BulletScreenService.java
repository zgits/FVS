package com.four.fvs.service;

import com.four.fvs.model.BulletScreen;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 18:01
 * @Description:
 */
public interface BulletScreenService {

    /**
     *
     * @param bulletScreen 返回发送的弹幕
     * @return
     */
    public String addBulletScreen(BulletScreen bulletScreen);


    /**
     * 根据视频的id和类型获取
     * @param videoId
     * @param type
     * @return
     */
    public List<BulletScreen> getBulletScreen(Integer videoId, Integer type);
}

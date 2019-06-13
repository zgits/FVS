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

    /*
     * 查询指定审核通过的视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public Video searchPassServicel(Integer id);

    /*
     * 编辑视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public boolean editVideoServicel(Video video);
}
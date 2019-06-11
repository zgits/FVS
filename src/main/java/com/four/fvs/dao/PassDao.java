package com.four.fvs.dao;

import com.four.fvs.model.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/4 10:51
 * @Description:
 */
@Repository
public interface PassDao {

    /**
     * 遍历未审核视频信息
     * @param
     * @return
     */
    public List<Video> getPassDao();

    /**
     * 删除视频
     * @param
     * @return
             */
    public Integer delVideoDao(@Param("id") Integer videoId);

    /*
     * 查询指定审核通过的视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public Video searchPassDao(@Param("id")Integer id);

    /*
     * 编辑视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public Integer editVideoDao(Video video);
}
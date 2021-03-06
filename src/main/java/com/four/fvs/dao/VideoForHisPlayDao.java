package com.four.fvs.dao;

import com.four.fvs.model.VideoForHisPlay;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 14:34.
 */
@Repository
public interface VideoForHisPlayDao {


    /**
     * 根据某个番剧id获取番剧
     * @param id
     * @return
     */
    public VideoForHisPlay getOneHisPlayById(Integer id);


    /**
     * 根据番剧id查询同属一个番剧的视频基本信息
     * @param hisPlayId
     * @return
     */
    public List<VideoForHisPlay> getTheSameHisPlayInfo(Integer hisPlayId);

    /**
     * 遍历指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public List<VideoForHisPlay> getVideoForHisPlayDao(Integer id);

    /**
     * 添加番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    public Integer addVideoForHisPlayDao(VideoForHisPlay videoForHisPlay);

    /**
     * 修改指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    public Integer editVideoForHisPlayDao(VideoForHisPlay videoForHisPlay);

    /**
     * 删除指定番剧视频VideoForHisPlay
     * @param
     * @return
     *
     */
    public Integer deldelVideoForHisPlayDao(Integer id);
}

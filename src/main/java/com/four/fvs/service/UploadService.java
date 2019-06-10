package com.four.fvs.service;

import java.util.List;
import com.four.fvs.model.HisPlay;
import com.four.fvs.model.VideoForHisPlay;

/**
 * @Author: hejiang
 * @Date: 2019/6/6 10:51
 * @Description:
 */
public interface UploadService {

    /**
     * 遍历番剧信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public List<HisPlay> getUploadServicel();

    /**
     * 修改番剧信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public boolean  editUploadServicel(HisPlay hisply);

    /**
     * 获取指定番剧HisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public HisPlay getDesignateServicel(Integer id);

    /**
     * 遍历指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public List<VideoForHisPlay> getVideoForHisPlayl(Integer id);

    /**
     * 添加番剧HisPlay信息
     * @param
     * @return
     *
     */
    public boolean addHisPlayServicel(String name, Integer playNumber, String introduce);

    /**
     * 添加番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    public boolean addVideoForHisPlayl(VideoForHisPlay videoForHisPlay);

    /**
     * 删除番剧HisPlay信息
     * @param
     * @return
     *
     */
    public boolean delHisPlayServicel(Integer id);

    /**
     * 修改指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    public boolean editVideoForHisPlayServicel(VideoForHisPlay videoForHisPlay);

    /**
     * 删除指定番剧视频VideoForHisPlay
     * @param
     * @return
     *
     */
    public boolean deldelVideoForHisPlayServicel(Integer id);


}

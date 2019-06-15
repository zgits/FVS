package com.four.fvs.service.impl;

import com.four.fvs.dao.UploadDao;
import com.four.fvs.dao.VideoForHisPlayDao;
import com.four.fvs.model.HisPlay;
import com.four.fvs.model.VideoForHisPlay;
import com.four.fvs.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/6 10:51
 * @Description:
 */
@Service
public class UploadServicelmpl implements UploadService {
    @Autowired
    private UploadDao uploadDao;
    @Autowired
    private VideoForHisPlayDao videoForHisPlayDao;
    /**
     * 遍历番剧信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public List<HisPlay> getUploadServicel(){
        return uploadDao.getUploadDao();
    }

    /**
     * 修改番剧信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public boolean  editUploadServicel(HisPlay hisply){
       return uploadDao.editUploadDao(hisply)>0;
    }

    /**
     * 获取指定番剧HisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public HisPlay getDesignateServicel(Integer id){
        return uploadDao.getDesignateDao(id);
    }

    /**
     * 遍历指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public List<VideoForHisPlay> getVideoForHisPlayl(Integer id){
        return videoForHisPlayDao.getVideoForHisPlayDao(id);
    }

    /**
     * 添加番剧HisPlay信息
     * @param
     * @return
     *
     */
    public boolean addHisPlayServicel(String name, Integer playNumber, String introduce){
        return uploadDao.addHisPlayServicel(name, playNumber, introduce)>0;
    }

    /**
     * 添加番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    public boolean addVideoForHisPlayl(VideoForHisPlay videoForHisPlay){
        return videoForHisPlayDao.addVideoForHisPlayDao(videoForHisPlay)>0;
    }

    /**
     * 删除番剧HisPlay信息
     * @param
     * @return
     *
     */
    public boolean delHisPlayServicel(Integer id){
        return uploadDao.delHisPlayDao(id)>0;
    }

    /**
     * 修改指定番剧视频VideoForHisPlay信息
     * @param
     * @return
     *
     */
    public boolean editVideoForHisPlayServicel(VideoForHisPlay videoForHisPlay){
        return videoForHisPlayDao.editVideoForHisPlayDao(videoForHisPlay)>0;
    }

    /**
     * 删除指定番剧视频VideoForHisPlay
     * @param
     * @return
     *
     */
    public boolean deldelVideoForHisPlayServicel(Integer id){
        return videoForHisPlayDao.deldelVideoForHisPlayDao(id)>0;
    }
}

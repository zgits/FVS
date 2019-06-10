package com.four.fvs.service.impl;

import com.four.fvs.dao.PassDao;
import com.four.fvs.model.Video;
import com.four.fvs.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/4 16:51
 * @Description:
 */
@Service
public class PassServicel implements PassService {

    @Autowired
    private PassDao passDao;

    /**
     * 遍历审核通过视频信息
     * @param
     * @return
     */
    @Override
    public List<Video> getPassService(){

        return passDao.getPassDao();
    }

    /**
     * 删除视频
     * @param
     * @return
     */
    public boolean delVideoService(Integer videoId){
        return passDao.delVideoDao(videoId)>0;
    }

    /*
     * 查询指定审核通过的视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */

    public List<Video> searchPassServicel(String searchContent){
        return passDao.searchPassDao(searchContent);
    }

    /*
     * 编辑视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public boolean editVideoServicel(Video video){
        return passDao.editVideoDao(video)>0;
    }
}
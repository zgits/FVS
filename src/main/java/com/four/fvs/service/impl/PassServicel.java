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
}
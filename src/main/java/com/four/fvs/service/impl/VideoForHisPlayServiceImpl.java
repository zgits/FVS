package com.four.fvs.service.impl;

import com.four.fvs.dao.VideoForHisPlayDao;
import com.four.fvs.model.VideoForHisPlay;
import com.four.fvs.service.VideoForHisPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 14:49.
 */
@Service
public class VideoForHisPlayServiceImpl implements VideoForHisPlayService {

    @Autowired
    private VideoForHisPlayDao videoForHisPlayDao;

    @Override
    public VideoForHisPlay getOneVideoById(Integer id) {
        return videoForHisPlayDao.getOneHisPlayById(id);
    }

    @Override
    public List<VideoForHisPlay> getTheSameHisPlayInfo(Integer hisPlayId) {
        return videoForHisPlayDao.getTheSameHisPlayInfo(hisPlayId);
    }
}

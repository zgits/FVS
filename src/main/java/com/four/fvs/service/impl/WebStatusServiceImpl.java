package com.four.fvs.service.impl;

import com.four.fvs.dao.WebStatusDao;
import com.four.fvs.model.Video;
import com.four.fvs.model.WebStatus;
import com.four.fvs.service.WebStatusService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author ljt
 * @Date 2019/5/29
 * @Description 查看网站情况service 实现类
 */

@Service
public class WebStatusServiceImpl implements WebStatusService {


    @Autowired
    private WebStatusDao webStatusDao;

    @Override
    @Transactional
    public Integer insertWebStatus(WebStatus webStatus) {
        return webStatusDao.insertWebStatus(webStatus);
    }

    @Override
    @Transactional
    public Integer countVisitForWeek(Date startTime, Integer day) {
        return webStatusDao.countVisitForWeek(startTime,day);
    }

    @Override
    @Transactional
    public Integer countVisitForTimeQuantum(Date startTime) {
        return webStatusDao.countVisitForTimeQuantum(startTime);
    }

    @Override
    @Transactional
    public List<Video> listTopVideoForVVs(Date startTime) {
        return webStatusDao.listTopVideoForVVs(startTime);
    }
}

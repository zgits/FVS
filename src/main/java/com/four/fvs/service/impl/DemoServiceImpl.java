package com.four.fvs.service.impl;

import com.four.fvs.dao.DemoDao;
import com.four.fvs.model.Demo;
import com.four.fvs.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zjf
 * @Date: 2019/5/13 23:03
 * @Description:
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public Integer insert(Demo demo) {

        return demoDao.insert(demo);
    }
}

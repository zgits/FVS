package com.four.fvs.service.impl;

import com.four.fvs.dao.BulletScreenDao;
import com.four.fvs.model.BulletScreen;
import com.four.fvs.service.BulletScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 18:03
 * @Description:
 */
@Service
public class BulletScreenServiceImpl implements BulletScreenService {


    @Autowired
    private BulletScreenDao bulletScreenDao;


    @Override
    public String addBulletScreen(BulletScreen bulletScreen) {
        bulletScreen.setDel(1);
        bulletScreenDao.addBulletScreen(bulletScreen);
        return bulletScreen.getText();
    }

    @Override
    public List<BulletScreen> getBulletScreen(Integer videoId, Integer type) {
        return bulletScreenDao.getBulletScreen(videoId, type);
    }
}

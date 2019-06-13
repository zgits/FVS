package com.four.fvs.service.impl;

import com.four.fvs.dao.AdDao;
import com.four.fvs.model.Advertising;
import com.four.fvs.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/9
 * @Description:
 */
@Service
public class AdServicel implements AdService {

    @Autowired
    private AdDao adDao;
    /*
     * 遍历广告信息
     *
     * */
    public List<Advertising> getAdvertisingServicel(){
        return adDao.getAdvertisingDao();
    }

    /*
     * 添加广告信息
     *
     * */
    public boolean addAdvertisingServicel(Advertising advertising){
        return adDao.addAdvertisingDao(advertising)>0;
    }

    /*
     * 删除广告
     *
     *
     * */
    public boolean delAdvertisingServicel(Integer id){
        return adDao.delAdvertisingDao(id)>0;
    }

    /*
     * 编辑广告
     *
     *
     * */
    public boolean editAdvertisingServicel(Advertising advertising){
        return adDao.editAdvertisingDao(advertising)>0;
    }
}

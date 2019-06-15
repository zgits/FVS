package com.four.fvs.service;

import com.four.fvs.model.Advertising;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/9
 * @Description:
 */
public interface AdService {
    /*
     * 遍历广告信息
     *
     * */
    public List<Advertising> getAdvertisingServicel();

    /*
     * 添加广告信息
     *
     * */
    public boolean addAdvertisingServicel(Advertising advertising);

    /*
     * 删除广告
     *
     *
     * */
    public boolean delAdvertisingServicel(Integer id);

    /*
     * 编辑广告
     *
     *
     * */
    public boolean editAdvertisingServicel(Advertising advertising);
}

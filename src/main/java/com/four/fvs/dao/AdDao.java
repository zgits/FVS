package com.four.fvs.dao;

import com.four.fvs.model.Advertising;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/9
 * @Description:
 */
@Repository
public interface AdDao {
    /*
     * 遍历广告信息
     *
     * */
    public List<Advertising> getAdvertisingDao();

    /*
     * 添加广告信息
     *
     * */
    public Integer addAdvertisingDao(Advertising advertising);

    /*
     * 删除广告
     *
     *
     * */
    public Integer delAdvertisingDao(Integer id);

    /*
     * 编辑广告
     *
     *
     * */
    public Integer editAdvertisingDao(Advertising advertising);
}

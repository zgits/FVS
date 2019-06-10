package com.four.fvs.dao;

import com.four.fvs.model.HisPlay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/6 10:51
 * @Description:
 */
@Repository
public interface UploadDao {

    /**
     * 遍历番剧信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public List<HisPlay> getUploadDao();

    /**
     * 修改番剧信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public Integer editUploadDao(HisPlay hisplay);

    /**
     * 获取指定番剧HisPlay信息
     * @param
     * @return
     * @ResponseBody：代表返回json数据格式
     */
    public HisPlay getDesignateDao(@Param("id") Integer id);

    /**
     * 添加番剧HisPlay信息
     * @param
     * @return
     *
     */
    public Integer addHisPlayServicel(@Param("name") String name, @Param("playNumber") Integer playNumber, @Param("introduce")String introduce);

    /**
     * 删除番剧HisPlay信息
     * @param
     * @return
     *
     */
    public Integer delHisPlayDao(@Param("id") Integer id);
}

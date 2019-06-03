package com.four.fvs.dao;

import com.four.fvs.model.Video;
import com.four.fvs.model.WebStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author ljt
 * @Date 2019/5/29
 * @Description 查看网站情况Dao层接口
 */

@Repository
public interface WebStatusDao {

    /**
     * 插入数据
     *
     * @param webStatus 网站情况
     * @return
     */
    Integer insertWebStatus(WebStatus webStatus);

    /**
     * 一周网站访问量
     *
     * @param startTime 开始时间
     * @return  返回访问量
     */
    Integer countVisitForWeek(@Param("visitTime") Date startTime);

    /**
     * 某天时刻访问量
     *
     * @param startTime 开始时间
     * @return 返回访问量
     */
    Integer countVisitForTimeQuantum(@Param("visitTime") Date startTime);

    /**
     *top10视频一周播放量
     *
     * @param startTime 开始时间
     * @return
     */
     List<Video> listTopVideoForVVs(@Param("watchTime") Date startTime);

}

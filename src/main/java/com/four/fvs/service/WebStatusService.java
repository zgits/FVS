package com.four.fvs.service;

import com.four.fvs.model.Video;
import com.four.fvs.model.WebStatus;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author ljt
 * @Date 2019/5/29
 * @Description 查看网站情况service层接口
 */

public interface WebStatusService {

    /**
     * 插入数据
     *
     * @param webStatus 网站情况实体类
     * @return
     */
    Integer insertWebStatus(WebStatus webStatus);

    /**
     * 一周网站访问量
     *
     * @param startTime 开始时间
     * @param day 周几
     * @return  返回访问量
     */
    Integer countVisitForWeek(Date startTime, Integer day);

    /**
     * 某天时刻访问量
     *
     * @param startTime 开始时间
     * @return 返回访问量
     */
    Integer countVisitForTimeQuantum(Date startTime);

    /**
     *top10视频一周播放量
     *
     * @param startTime 开始时间
     * @return
     */
    List<Video> listTopVideoForVVs(Date startTime);
}

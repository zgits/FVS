package com.four.fvs.service;

import com.four.fvs.model.Video;

import java.util.List;
/**
 * @Author: hejiang
 * @Date: 2019/6/4 10:51
 * @Description:
 */
public interface AuditingService {

    /**
     * 遍历未审核视频信息
     * @param
     * @return
     */
    public List<Video> getAuditingServiceByPage(int pageNo, int pageSize);

}

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
    public List<Video> getAuditingService();

    /**
     * 未审核视频审核通过
     * @param
     * @return
     */
    public boolean passAuditing(Integer videoId);
}

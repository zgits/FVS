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
    public List<Video> getAuditingServicel();

    /**
     * 未审核视频审核通过
     * @param
     * @return
     */
    public boolean passAuditingServicel(Integer videoId);

    /**
     * 未审核视频审核不通过
     * @RequestParam("id"):获取选中视频id
     * @return
     *
     */
    public boolean notPassAuditingServicel(Integer videoId);

    /*
     * 查询未审核视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public List<Video> searchAuditingServicel(String searchContent);
}

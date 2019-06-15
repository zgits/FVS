package com.four.fvs.service.impl;

import com.four.fvs.dao.AuditingDao;
import com.four.fvs.model.Video;
import com.four.fvs.service.AuditingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/4 16:51
 * @Description:
 * @Service：标志着这个类属于Service实现层
 */
@Service
public class AuditingServicel implements AuditingService {

    @Autowired
    private AuditingDao auditingDao;

    /**
     * 遍历未审核通过视频信息
     * @param
     * @return
     */
    @Override
    public List<Video> getAuditingServicel(){
        List<Video> listVideo = auditingDao.getAuditingDao();

        return listVideo;
    }

    /**
     * 未审核视频审核通过
     * @param
     * @return
     */
    public boolean passAuditingServicel(Integer videoId){
        return auditingDao.passAuditingDao(videoId)>0;
    }

    /**
     * 未审核视频审核不通过
     * @RequestParam("id"):获取选中视频id
     * @return
     *
     */
    public boolean notPassAuditingServicel(Integer videoId){
        return auditingDao.notPassAuditingDao(videoId)>0;
    }

    /*
     * 查询未审核视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public List<Video> searchAuditingServicel(String searchContent){
        return auditingDao.searchAuditingDao(searchContent);
    }
}

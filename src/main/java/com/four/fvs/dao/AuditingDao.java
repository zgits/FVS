package com.four.fvs.dao;

import com.four.fvs.model.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hejiang
 * @Date: 2019/6/4 10:51
 * @Description:
 * @Repository: 标志着这个类属于Dao层的
 */
@Repository
public interface AuditingDao {

    /**
     * 遍历未审核视频信息
     * @param
     * @return
     */
    public List<Video> getAuditingDao();

    /**
     * 未审核视频审核通过
     * @param
     * @return
     */
    public Integer passAuditingDao(@Param("id") Integer videoId);
}

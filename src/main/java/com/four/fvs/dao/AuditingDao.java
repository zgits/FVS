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

    /**
     * 未审核视频审核不通过
     * @RequestParam("id"):获取选中视频id
     * @return
     *
     */
    public Integer notPassAuditingDao(@Param("id") Integer videoId);

    /*
     * 查询未审核视频信息
     *@RequestParam("searchContent")：获取用户要查询的信息
     * 返回查询信息
     *
     * */
    public List<Video> searchAuditingDao(@Param("searchContent")String searchContent);
}

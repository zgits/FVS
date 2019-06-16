package com.four.fvs.dao;

import com.four.fvs.model.User;
import com.four.fvs.model.Video;
import com.four.fvs.vo.VideoIndexVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 16:30
 * @Description: 普通视频的数据库接口
 */
@Repository
public interface VideoDao {

    /**
     * 用户播放视频时，根据视频id获取视频数据
     * @param id
     * @return
     */
    public Video getOneVideoById(@Param("id") Integer id);


    /**
     * 视频播放数量的增加
     * @param id
     * @return
     */
    public Integer updateVideovv(Integer id);


    /**
     * 点赞数量增加
     * @param videoId
     * @param number +1或者-1，根据是否有点赞记录来决定
     * @return
     */
    public Integer givePraise(@Param("id") Integer videoId,@Param("number")Integer number);



    /**
     * 分享数量的增加
     * @param videoId
     * @return
     */
    public Integer giveShare(@Param("id")Integer videoId);


    /**
     * 收藏数量的增加
     * @param videoId
     * @param number +1或者-1，根据是否有收藏记录来决定
     * @return
     */
    public Integer giveCollection(@Param("id")Integer videoId,@Param("number")Integer number);

    /**
     * 获取首页视频
     * @return
     */
    public List<Video> getAllVideo();

    /**
     * 获取制定分区排行榜
     */
    public List<Video> getVideoRank(@Param("typeId") Integer typeId);

    /**
     * 根据视频的类型或者是用户id得到相似的视频信息
     * @param type
     * @param userId
     * @return
     */
    public List<Video> getTheSameVideo(@Param("userId")Integer userId, @Param("type") Integer type);

    /**
     * 获取某一分区视频数量
     */
    public Integer getVideoCountByType(@Param("typeId") Integer typeId);

    /**
     * 按分区分页展示视频信息
     * @param typeId
     * @param begin
     * @param size
     * @return
     */
    public List<Video> getVideoByType(@Param("typeId") Integer typeId,
                                      @Param("begin")Integer begin,
                                      @Param("size")Integer size);

    public List<Video> getVideoByType1(Integer typeId);

    /**
     * 根据名称分页查询视频
     * @param name
     * @param begin
     * @param size
     * @return
     */
    public List<Video>getVideoByName(@Param("name") String name,
                                     @Param("begin")Integer begin,
                                     @Param("size")Integer size);

    public List<Video>getVideoByName1(@Param("name") String name);

    /**
     * 根据名字和类型查询视频
     *
     */
    public List<Video>getVideoByNameAndType(@Param("name") String name,
                                     @Param("typeId")Integer typeId,
                                     @Param("begin")Integer begin,
                                     @Param("size")Integer size);

    /**
     * 根据名称模糊分页查询查询用户
     */
    public List<User>getUserByName(@Param("name") String name,
                                   @Param("begin")Integer begin,
                                   @Param("size")Integer size);
    public List<User>getUserByName1(@Param("name") String name);

    /**
     * 查询分区一天内更新数量
     * @param typeId
     * @return
     */
    public Integer getUpdateCount(Integer typeId);
    /**
     * 根据id获取CollectVideo
     * @param id
     * @return
     */
    public List<Video> getCollectVideo(@Param("id") Integer id);

    /**
     * 根据id获取收藏Video
     * @param id
     * @return
     */
    public List<Video> getShoucangVideo(@Param("id") Integer id);

}

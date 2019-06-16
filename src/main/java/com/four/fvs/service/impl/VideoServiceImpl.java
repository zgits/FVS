package com.four.fvs.service.impl;

import com.four.fvs.common.PageBean;
import com.four.fvs.dao.*;
import com.four.fvs.model.User;
import com.four.fvs.model.Video;
import com.four.fvs.model.VideoOpRecord;
import com.four.fvs.service.FocusService;
import com.four.fvs.service.TypeService;
import com.four.fvs.service.UserService;
import com.four.fvs.service.VideoService;
import com.four.fvs.vo.UserVo;
import com.four.fvs.vo.VideoIndexVo;
import com.four.fvs.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/5/25 16:38
 * @Description:
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;
    @Autowired
    private VideoCommentDao videoCommentDao;
    @Autowired
    private FocusDao focusDao;
    @Autowired
    private UserDao userDao;

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoOpRecordDao videoOpRecordDao;


    @Autowired
    private UserService userService;


    @Autowired
    private FocusService focusService;

    @Autowired
    private TypeService typeService;


    @Override
    public VideoVo getOneVideoById(Integer videoId) {


        System.out.println(videoId);
        Video video=videoDao.getOneVideoById(videoId);
        if(video==null){
            return null;
        }
        VideoVo videoVo=new VideoVo();

        User user=userService.getUserInfo(video.getUserId());

        videoVo.setVideo(video);
        videoVo.setFocus(focusService.getFocusNumber(video.getUserId()));

        videoVo.setUserName(user.getUserName());
        videoVo.setIcon(user.getIcon());
        videoVo.setUserId(user.getId());
        videoVo.setType(typeService.getTypeName(video.getTypeId()));
        return videoVo;
    }

    @Override
    public Integer updateVideovv(Integer id) {
        return videoDao.updateVideovv(id);
    }

    @Override
    public String givePraise(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(1);
        videoOpRecord.setTime(new Date());
        VideoOpRecord videoOpRecord1=videoOpRecordDao.getRecord(videoOpRecord);
        int number=videoOpRecord1!=null?-1:1;
        if(videoOpRecord1!=null){
            videoOpRecordDao.delRecord(videoOpRecord);
        }else{
            videoOpRecordDao.addRecord(videoOpRecord);
        }
        videoDao.givePraise(videoOpRecord.getVideoId(),number);
        return videoOpRecord1!=null?"del":"add";
    }

    @Override
    public boolean giveShare(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(2);
        videoOpRecord.setTime(new Date());
        videoOpRecordDao.addRecord(videoOpRecord);
        return videoDao.giveShare(videoOpRecord.getVideoId())>0;
    }

    /**
     * 还要加上用户的实际收藏操作
     * @param videoOpRecord
     * @return
     */
    @Override
    public String giveCollection(VideoOpRecord videoOpRecord) {
        videoOpRecord.setOpType(3);
        videoOpRecord.setTime(new Date());
        VideoOpRecord videoOpRecord1=videoOpRecordDao.getRecord(videoOpRecord);
        System.out.println(videoOpRecord1);
        if(videoOpRecord1!=null){
            videoOpRecordDao.delRecord(videoOpRecord);
        }else{
            videoOpRecordDao.addRecord(videoOpRecord);
        }
        int number=videoOpRecord1!=null?-1:1;
        videoDao.giveCollection(videoOpRecord.getVideoId(),number);
        return videoOpRecord1!=null?"del":"add";
    }

    /**
     * 首页视频信息
     * @return
     */
    @Override
    public List<VideoIndexVo> getAllVideo(){
        List<Video> video=videoDao.getAllVideo();
       List<VideoIndexVo> videoIndexVo=new ArrayList<VideoIndexVo>();
        Integer videoId;
        //Integer type=0;
        for(int i=0;i<video.size();i++){
            VideoIndexVo vi=new VideoIndexVo();
            videoId=video.get(i).getId();
            if(video.get(i).getVv()==null){
                video.get(i).setVv(0);
            }

            vi.setDel(video.get(i).getDel());
            vi.setTypeId(video.get(i).getTypeId());
            vi.setFirstImagePath(video.get(i).getFirstImagePath());
            vi.setId(video.get(i).getId());
            vi.setName(video.get(i).getName());
            vi.setUpTime(video.get(i).getUpTime());
            vi.setVv(video.get(i).getVv());
            vi.setVideoLength(video.get(i).getVideoLength());
            vi.setVideoSrc(video.get(i).getVideoSrc());

            //type=videoCommentDao.getOneVideoCommentById(videoId).getType();
            vi.setCommentCount(videoCommentDao.getCount(videoId,1));
            vi.setTypename(typeService.getTypeName(video.get(i).getTypeId()));

            videoIndexVo.add(vi);

        }
        /*for(VideoIndexVo vii: videoIndexVo){
            System.out.println(vii);
        }*/
        return videoIndexVo;
    }

    @Override
    public List<VideoVo> getTheSameVideo(Integer userId, Integer type) {
        List<Video> videos=videoDao.getTheSameVideo(userId,type);

        List<VideoVo> result=new ArrayList<>();
        VideoVo videoVo;
        for (Video video : videos) {
            User user=userService.getUserInfo(video.getUserId());
            videoVo=new VideoVo();
            videoVo.setVideo(video);
            videoVo.setIcon(user.getIcon());
            videoVo.setUserId(user.getId());
            videoVo.setUserName(user.getUserName());
            result.add(videoVo);
        }
        return result;

    }

    @Override
    public boolean getIfExistOpRecord(VideoOpRecord videoOpRecord) {
        return videoOpRecordDao.getRecord(videoOpRecord)!=null;
    }

    /**
     * 获取分区排行榜
     * @param typeId
     * @return
     */
    @Override
    public List<Video> getVideoRank(Integer typeId){
        return videoDao.getVideoRank(typeId);
    }

    /**
     *获取各分区视频数量
     * @return
     */
    @Override
     public List<Integer> getAllCount(){
        List<Integer>counts=new ArrayList<>();
        Integer count;
        Integer num=typeService.getAllType().size();
        for(int i=0;i<num;i++){
            count=videoDao.getVideoCountByType(typeService.getAllType().get(i).getId());
            counts.add(count);
        }

        return counts;

    }

    /**
     *分页展示各分区视频内容
     * @param typeId
     * @param currPage
     * @return
     */
    public PageBean<VideoIndexVo> getVideoByType(Integer currPage, Integer typeId){
        PageBean<VideoIndexVo> videos=new PageBean<>();
        List<VideoIndexVo> videolist=new ArrayList<>();
        Integer size=30;//默认每页展示30条视频
        Integer count=videoDao.getVideoByType1(typeId).size();//该分区下总视频数
        videos.setCurrPage(currPage);
        videos.setPageSize(size);
        videos.setTotalCount(count);
        Integer begin=(currPage-1)*30;//下一页开始位置
        double tc=count;
        Double pageCount=Math.ceil(tc/size);
        videos.setTotalPage(pageCount.intValue());

        List<Video> video=videoDao.getVideoByType(typeId,begin,size);

        Integer videoId;
        for(int i=0;i<video.size();i++){
            VideoIndexVo vi=new VideoIndexVo();
            videoId=video.get(i).getId();
            if(video.get(i).getVv()==null){
                video.get(i).setVv(0);
            }

            vi.setDel(video.get(i).getDel());
            vi.setTypeId(video.get(i).getTypeId());
            vi.setFirstImagePath(video.get(i).getFirstImagePath());
            vi.setId(video.get(i).getId());
            vi.setName(video.get(i).getName());
            vi.setUpTime(video.get(i).getUpTime());
            vi.setVv(video.get(i).getVv());
            vi.setVideoLength(video.get(i).getVideoLength());
            vi.setVideoSrc(video.get(i).getVideoSrc());

            vi.setCommentCount(videoCommentDao.getCount(videoId,1));
            vi.setTypename(typeService.getTypeName(video.get(i).getTypeId()));

            videolist.add(vi);

        }
        videos.setLists(videolist);
        return videos;
    }

    /**
     * 根据名称模糊查询视频
     */
    @Override
    public PageBean<VideoIndexVo>getVideoByName( Integer currPage, String name) {
        PageBean<VideoIndexVo> videos=new PageBean<>();
        List<VideoIndexVo> videolist=new ArrayList<>();
        Integer size=20;//默认每页展示20条视频
        Integer count=videoDao.getVideoByName1(name).size();//该分区下总视频数
        videos.setCurrPage(currPage);
        videos.setPageSize(size);
        videos.setTotalCount(count);
        Integer begin=(currPage-1)*20;//下一页开始位置
        double tc=count;
        Double pageCount=Math.ceil(tc/size);
        videos.setTotalPage(pageCount.intValue());

        List<Video> video=videoDao.getVideoByName(name,begin,size);
        Integer videoId;
        for(int i=0;i<video.size();i++){
            VideoIndexVo vi=new VideoIndexVo();
            videoId=video.get(i).getId();

            if(video.get(i).getVv()==null){
                video.get(i).setVv(0);
            }

            vi.setDel(video.get(i).getDel());
            vi.setTypeId(video.get(i).getTypeId());
            vi.setFirstImagePath(video.get(i).getFirstImagePath());
            vi.setId(video.get(i).getId());
            vi.setName(video.get(i).getName());
            vi.setUpTime(video.get(i).getUpTime());
            vi.setVv(video.get(i).getVv());
            vi.setVideoLength(video.get(i).getVideoLength());
            vi.setVideoSrc(video.get(i).getVideoSrc());
            vi.setCommentCount(videoCommentDao.getCount(videoId,1));
            vi.setTypename(typeService.getTypeName(video.get(i).getTypeId()));

            videolist.add(vi);

        }
        videos.setLists(videolist);
        return videos;

    }

    public PageBean<UserVo> getUserByName(Integer currpage, String name){
        PageBean<UserVo> users=new PageBean<>();
        List<UserVo> userlist=new ArrayList<>();
        Integer size=7;//默认每页展示7条用户信息
        Integer count=videoDao.getUserByName1(name).size();//该分区下总视频数
        users.setCurrPage(currpage);
        users.setPageSize(size);
        users.setTotalCount(count);
        Integer begin=(currpage-1)*7;//下一页开始位置
        double tc=count;
        Double pageCount=Math.ceil(tc/size);
        users.setTotalPage(pageCount.intValue());

        List<User> user=videoDao.getUserByName(name,begin,size);
        Integer UserId;
        for(int i=0;i<user.size();i++){
            UserVo uv=new UserVo();
            UserId=user.get(i).getId();

           /* if(user.get(i).getVv()==null){
                video.get(i).setVv(0);
            }*/
            uv.setCreateTime(user.get(i).getCreateTime());
            uv.setDel(user.get(i).getDel());
            uv.setId(user.get(i).getId());
            uv.setDel(user.get(i).getDel());
            uv.setIcon(user.get(i).getIcon());
            uv.setUserName(user.get(i).getUserName());
            uv.setIntroduce(user.get(i).getIntroduce());
            uv.setRoleId(user.get(i).getRoleId());
            uv.setSex(user.get(i).getSex());
            uv.setFans(focusDao.getCountFocus(UserId));
            uv.setVideocount(userDao.getVideoCount(UserId));

            userlist.add(uv);

        }
        users.setLists(userlist);
        return users;
    }


    /**
     * 通过id得到cOLLECTVIDEO
     *
     * @param id
     * @return
     */
    public List<Video> getCollectVideoService(Integer id) {
        return videoDao.getCollectVideo(id);
    }

    /**
     * 通过id得到cOLLECTVIDEO
     *
     * @param id
     * @return
     */
    public List<Video> getShoucangVideoService(Integer id) {
        return videoDao.getShoucangVideo(id);
    }



    /**
     * 获取一天的更新数量
     * @param typeId
     * @return
     */
    @Override
    public Integer getUpdateCount(Integer typeId){
        return videoDao.getUpdateCount(typeId);

    }
}


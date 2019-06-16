package com.four.fvs.service.impl;

import com.four.fvs.BaseTest;
import com.four.fvs.service.TypeService;
import com.four.fvs.service.VideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class VideoServiceImplTest extends BaseTest {

    @Autowired
    private VideoService videoService;
    @Autowired
    private TypeService typeService;

    @Test
    public void getOneVideoById() {
    }

    @Test
    public void givePraise() {
    }

    @Test
    public void giveShare() {
    }

    @Test
    public void giveCollection() {
    }

    @Test
    public void getAllVideo()throws Exception{
       // videoService.getAllVideo();
       //System.out.println(videoService.getUpdateCount(1));
    }
    @Test
    public void getVideoRank(){
      //  System.out.println(videoService.getVideoByType(1,1).getLists().size());
    }
}

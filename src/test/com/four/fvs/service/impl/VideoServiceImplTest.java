package com.four.fvs.service.impl;

import com.four.fvs.BaseTest;
import com.four.fvs.service.VideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class VideoServiceImplTest extends BaseTest {

    @Autowired
    private VideoService videoService;

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
    public void getAllVideo() {
        System.out.println(videoService.getAllVideo());
    }
}

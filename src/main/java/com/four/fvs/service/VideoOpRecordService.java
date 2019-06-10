package com.four.fvs.service;

import com.four.fvs.common.PageBean;
import com.four.fvs.vo.OpRecordVo;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/6/4 20:19
 * @Description:
 */
public interface VideoOpRecordService {

    /**
     * 获取该用户被点赞的信息
     * @param userId
     * @param currPage
     * @return
     */
    public PageBean<OpRecordVo> getUserPraise(Integer currPage, Integer userId);
}

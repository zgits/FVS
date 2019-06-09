package com.four.fvs.service;

import com.four.fvs.model.Focus;

/**
 * @Description:
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 15:52.
 */
public interface FocusService {

    /**
     * 根据userId获取关注数
     * @param userId
     * @return
     */
    public Integer getFocusNumber(Integer userId);


    /**
     * 对某个用户添加关注
     * @param focus
     * @return
     */
    public boolean addFocus(Focus focus);


    /**
     * 取消对某个用户的关注
     * @param focus
     * @return
     */
    public boolean delFocus(Focus focus);

    /**
     * 判断某个关注是否存在
     * @param focus
     * @return
     */
    public boolean ifExist(Focus focus);

}

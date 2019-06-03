package com.four.fvs.service.impl;

import com.four.fvs.dao.FocusDao;
import com.four.fvs.model.Focus;
import com.four.fvs.service.FocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/6/3 15:58.
 */
@Service
public class FocusServiceImpl implements FocusService {

    @Autowired
    private FocusDao focusDao;

    @Override
    public Integer getFocusNumber(Integer userId) {
        return focusDao.getCountFocus(userId);
    }

    @Override
    public boolean addFocus(Focus focus) {
        return focusDao.addFocus(focus)>0;
    }
}

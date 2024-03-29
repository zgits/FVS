package com.four.fvs.service.impl;

import com.four.fvs.dao.TypeDao;
import com.four.fvs.model.Type;
import com.four.fvs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/6/8 14:04
 * @Description:
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public String getTypeName(Integer id) {
        return typeDao.getTypeName(id);
    }

    @Override
    public List<Type> getAllType(){
        return typeDao.getAllType();
    }
}

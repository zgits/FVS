package com.four.fvs.service.impl;

import com.four.fvs.dao.AuditingDao;
import com.four.fvs.model.Video;
import com.four.fvs.service.AuditingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditingServicel implements AuditingService {

    @Autowired
    private AuditingDao auditingDao;

    @Override
    public List<Video> getAuditingService(){

        return auditingDao.getAuditingDao();
    }
}

package com.four.fvs.controller;

import com.four.fvs.common.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.four.fvs.service.AuditingService;
import com.four.fvs.common.Result;

@Controller
@RequestMapping("Auditing")
public class AuditingController {
    @Autowired
    private AuditingService auditingService;

    @ResponseBody
        @GetMapping("getAuditing")
    public Result<Object> getAuditing(){

        return ResultUtils.success(auditingService.getAuditingService());
    }
}

package com.four.fvs.controller;

import com.four.fvs.common.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.four.fvs.service.AuditingService;
import com.four.fvs.common.Result;

/**
 * @Author: hejiang
 * @Date: 2019/6/4 10:51
 * @Description:
 */
@Controller
@RequestMapping("Auditing")
public class AuditingController {
    @Autowired
    private AuditingService auditingService;

    /**
     * 遍历未审核视频信息
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("getAuditing")
    public Result<Object> getAuditing(@RequestParam(name = "pageNo")Integer pageNo, @RequestParam(name = "pageSize")Integer pageSize,
                                      @RequestParam(name="searchValue")String searchValue){
        return ResultUtils.success(auditingService.getAuditingServiceByPage(pageNo, pageSize));
    }
}

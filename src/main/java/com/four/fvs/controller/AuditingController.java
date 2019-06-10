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
     * @ResponseBody：代表返回json数据格式
     * @GetMapping等价于@RequestMapping的GET请求方式
     */
    @ResponseBody
    @GetMapping("getAuditing")
    public Result<Object> getAuditing(){
        return ResultUtils.success(auditingService.getAuditingServicel());
    }

    /**
     * 未审核视频审核通过
     * @RequestParam("id"):获取选中视频id
     * @return
     *
     */
    @ResponseBody
    @GetMapping("passAuditing")
    public Result<Object> passAuditing(@RequestParam("id")Integer videoId){
        auditingService.passAuditingServicel(videoId);
        return getAuditing();
    }

    /**
     * 未审核视频审核不通过
     * @RequestParam("id"):获取选中视频id
     * @return
     *
     */
    @ResponseBody
    @GetMapping("notPassAuditing")
    public Result<Object> notPassAuditing(@RequestParam("id")Integer videoId){
        auditingService.notPassAuditingServicel(videoId);
        return getAuditing();
    }

    /*
    * 查询未审核视频信息
    *@RequestParam("searchContent")：获取用户要查询的信息
    * 返回查询信息
    *
    * */
    @ResponseBody
    @GetMapping("searchNotPassAuditing")
    public Result<Object> searchNotPassAuditing(@RequestParam("searchContent")String searchContent){
        return ResultUtils.success(auditingService.searchAuditingServicel(searchContent));
    }
}

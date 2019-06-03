package com.four.fvs.aop;

import com.four.fvs.common.Result;
import com.four.fvs.common.ResultUtils;
import com.four.fvs.exception.NotLoginException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: zjf
 * @Date: 2019/6/3 12:46
 * @Description:
 */
@Aspect
@Component
public class TestAop {


    @Before(value = "execution(* com.four.fvs.controller.*.*(..))")
    public Result<Object> aop(){
        System.out.println("前置aop测试");
        try {
            throw new NotLoginException();
        } catch (NotLoginException e) {
            e.printStackTrace();
        }
        return ResultUtils.unloginerror();
    }
}

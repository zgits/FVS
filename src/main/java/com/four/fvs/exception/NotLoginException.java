package com.four.fvs.exception;

import javax.servlet.ServletException;

/**
 * @Author: zjf
 * @Date: 2019/6/3 12:55
 * @Description:
 */
public class NotLoginException extends RuntimeException {


    public NotLoginException() {
        super();
    }
    public NotLoginException(String msg,Throwable cause) {
        super(msg,cause);

    }

}

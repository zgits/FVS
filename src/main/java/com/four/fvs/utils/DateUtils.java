package com.four.fvs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zjf
 * @Date: 2019/5/22 12:49
 * @Description: 有关日期的操作
 */
public class DateUtils {

    /**
     * 将日期转换为字符串并以yyyyMMddHHmmss的格式返回
     * @param date
     * @return
     */
    public static String DateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);       //将Date类型转换成String类型
        return format;
    }
}

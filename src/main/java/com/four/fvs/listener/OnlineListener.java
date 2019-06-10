package com.four.fvs.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

/**
 * @Author: ljt
 * @Date: 2019/6/4
 * @Description: 在线人数监听器
 */

public class OnlineListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        //使用set 来存储session对象，方便去重
        HashSet<HttpSession> sessionHashSet = (HashSet<HttpSession>) servletContext.getAttribute("sessionHashSet");
        if(sessionHashSet == null){
            sessionHashSet = new HashSet<HttpSession>();
            servletContext.setAttribute("sessionHashSet", sessionHashSet);
        }
        //这里主要是为了检验用户是否登录，登录的话强制移除该session，加入新session
        for(HttpSession s : sessionHashSet){
            if(session.getAttribute("nickname").equals(s.getAttribute("nickname"))){
                sessionHashSet.remove(s);
            }
        }
        sessionHashSet.add(session);
        //存储在线人数，利用了set集合不重复的特性，避免了重复登录
        servletContext.setAttribute("lineCount", sessionHashSet.size());
    }


    /**
     * 每当session销毁，在线人数减1
     *
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        if (servletContext.getAttribute("lineCount") == null) {
            servletContext.setAttribute("lineCount", 0);
        } else {
            int lineCount = (Integer) servletContext.getAttribute("lineCount");
            if (lineCount < 1) {
                lineCount = 1;
            }
            servletContext.setAttribute("lineCount", lineCount - 1);
        }
        HttpSession session = se.getSession();
        HashSet<HttpSession> sessionSet = (HashSet<HttpSession>)servletContext.getAttribute("sessionHashSet");
        if(sessionSet!=null){
            sessionSet.remove(session);
        }

    }
}

package com.gai.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/LastAccessTime")
public class LastAccessTime extends HttpServlet {
    private static final String COOKIE_KEY_LASTACCESSTIME = "COOKIE_KEY_LASTACCESSTIME";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        String lastAccessTime = null;
        if(cookies != null){
            for (Cookie cookie : cookies){
                if(LastAccessTime.COOKIE_KEY_LASTACCESSTIME.equals(cookie.getName())){
                    lastAccessTime = cookie.getValue();
                    break;
                }
            }
        }

        if(lastAccessTime == null){
            resp.getWriter().write("第一次访问");
        }else {
            resp.getWriter().write("上一次访问时间是" + lastAccessTime);
        }
        String currenttime = new SimpleDateFormat("yyyy-MM-dd*hh:mm:ss").format(new Date());
        System.out.println(currenttime);
        Cookie cookie = new Cookie(LastAccessTime.COOKIE_KEY_LASTACCESSTIME,currenttime);
        cookie.setMaxAge(60*60*24);
        resp.addCookie(cookie);
    }
}

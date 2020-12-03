package com.gai.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/ThreadSafeServlet",loadOnStartup = 1)
public class ThreadSafeServlet extends HttpServlet {
    public static String name = "Hello";   //静态变量，可能发生线程安全问题
    int i;  //实例变量，可能发生线程安全问题

    @Override
    public void init() throws ServletException {
        super.init();
        i++;
        System.out.println("ThreadSafeServlet 初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("%s：%s\n",Thread.currentThread().getName(),i);
        resp.getWriter().println("<html><body><h1>" + i + "</h1></body></html>");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.printf("%s：%s[%s]\n", Thread.currentThread().getName(), i, format.format(new Date()));
    }
}

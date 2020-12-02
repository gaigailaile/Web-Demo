package com.gai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle(){
        System.out.println("ServletLifeCycle 初始化");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ServletLifeCycle init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletLifeCycle service doGet()");
    }

    @Override
    public void destroy() {
        System.out.println("ServletLifeCycle destroy()");
    }
}

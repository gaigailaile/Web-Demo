package com.gai.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null){
            String name = (String) session.getAttribute("name");
            resp.getWriter().write(name==null ? "null" : name);
        }else {
            resp.getWriter().write("session为 null !!!");
        }
    }
}

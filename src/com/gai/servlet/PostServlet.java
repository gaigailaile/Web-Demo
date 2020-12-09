package com.gai.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html"); //响应的文件是文本形式的html文件
        PrintWriter printWriter = resp.getWriter(); //获得输出流对象
        printWriter.print("<!DOCTYPE><html><head><title>user login</title></head>");
        printWriter.print("<body>");
        if("admin".equals(username)&& "admin123".equals(password)){
            printWriter.print("welcome "+username);
        }else{
            printWriter.print("<font color='red'>username or password is wrong</font>");
        }
        printWriter.print("</body></html>");

        printWriter.flush();
        printWriter.close();
    }

//    private JSONObject getJsonInfo(HttpServletRequest request) {
//        JSONObject json = new JSONObject();
//        try {
//            InputStreamReader in = new InputStreamReader(request.getInputStream(), "utf-8");
//            BufferedReader br = new BufferedReader(in);
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//                sb.append(line);
//            }
//            br.close();
//            json = JSONObject.fromObject(sb.toString());
//            System.out.println("从前端接收到的json数据：" + json);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return json;
//    }
}

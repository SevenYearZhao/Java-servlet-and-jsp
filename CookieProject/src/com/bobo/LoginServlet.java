package com.bobo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户在pageServlet中输入的用户名和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        //如果用户名为"bobo",密码为"123"则视为正确，保存cookie，然后跳转到登录界面
        if ("bobo".equals(username) && "123".equals(password)){
            //创建cookie
            Cookie cookie=new Cookie("uid",username);
            //设置cookie时间为7天
            cookie.setMaxAge(7*24*3600);
            //保存cookie
            response.addCookie(cookie);
            response.sendRedirect("success");
        }else {
            //否则，跳转到登录失败界面
            response.sendRedirect("fail");
        }
    }
}

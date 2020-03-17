package com.bobo;

import com.bobo.entry.User;
import com.bobo.service.UserService;
import com.bobo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");

        //获取客户端输入的用户名和密码
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(userName + ":" + password);
        //验证数据库中是否存在此用户名和密码
        User requestUser = new User(userName, password);
        UserService userService = new UserServiceImpl();
        User resultUser = userService.checkUser(requestUser);

        HttpSession session = request.getSession();
        session.setAttribute("name", userName);

        if (resultUser != null) {
            response.sendRedirect("success");
        } else {
            response.sendRedirect("fail");
        }
    }
}

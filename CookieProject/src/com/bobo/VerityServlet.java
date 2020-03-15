package com.bobo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //resp.setCharacterEncoding("gbk");

        //获取cookie
        Cookie[] cookies = req.getCookies();
        //如果cookie为空，则跳转到登录界面
        if (cookies==null || cookies.length==0){
            resp.sendRedirect("page");
        }else {
            for (Cookie cookie : cookies){
                if ("uid".equals(cookie.getName())){
                    //验证密码，这里本来是要调用sql语句来查询验证，由于目前没装MySQL，所以这里直接写死，当用户名为"bobo"时，证明验证成功
                    if ("bobo".equals(cookie.getValue())){
                        //跳转到登录成功页面
                        resp.sendRedirect("success");
                    }else {
                        //验证失败则重新登录
                        resp.sendRedirect("page");
                    }
                    return;
                }
            }
            resp.sendRedirect("page");
        }
    }
}

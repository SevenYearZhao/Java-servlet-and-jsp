package com.bobo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * HttpServletRequest:用来存储客户端请求的参数
 * 请求头
 * 请求行
 * 请求体
 *
 * HttpServletResponse:表示服务端返回数据的响应对象
 * 响应头
 * 响应行
 * 响应体
 */
public class MyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post 请求");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get 请求");
        /**
         * 获取请求行信息
         */
        //获取请求中的请求方式
        System.out.println("请求方式：" + request.getMethod());
        //获取请求中的完整地址
        System.out.println("请求URL：" + request.getRequestURL());
        //获取请求中的资源路径
        System.out.println("请求URI：" + request.getRequestURI());
        //获取请求中的协议
        System.out.println("请求协议：" + request.getScheme());

        /**
         * 获取请求头信息
         */
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + ":" + value);
        }

        /**
         * 获取用户请求参数，注意：无论用户请求方式是Get还是Post，获取用户请求的方式不变
         */
        //注意：这里的参数要和jsp表单中的name属性相同
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        System.out.println("username:" + username + " password:" + password);
        //第二种方式
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = request.getParameter(key);
            System.out.println("key:" + key + " value:" + value);
        }
        //获取相同名字的多个值，例如checkbox
        String[] favs = request.getParameterValues("fav");
        System.out.println(Arrays.toString(favs));

        /**
         * 其它常用方法
         */
        //获取远程客户端地址、端口
        System.out.println("RemoteAddr："+request.getRemoteAddr()+" RemotePort:"+request.getRemotePort());
        //获取本机地址、本机名
        System.out.println("LocalAddr："+request.getLocalAddr()+" LocalName:"+request.getLocalName());


        /**
         * ---------响应信息
         */
        //服务端返回数据的格式
        response.setHeader("Context-Type","text/html");
        //response.setContentType("text/html");

        //设置响应头，两种方式：1、setHeader 2、addHeader
        //如果存在相同的key会覆盖上一个值
        response.setHeader("set","bobo1");
        response.setHeader("set","bobo2");
        //如果存在相同的key，不会覆盖上一个值
        response.addHeader("add","bobo1");
        response.addHeader("add","bobo2");

        response.getWriter().write("<b>this is back data<b>");
    }
}

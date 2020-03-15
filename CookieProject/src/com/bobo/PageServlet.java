package com.bobo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PageServlet");
        response.setCharacterEncoding("gbk");
        response.setContentType("text/html");
        PrintWriter printWriter=response.getWriter();
        printWriter.write("<html>");
        printWriter.write("<body>");
        printWriter.write("<form action=\"login\" method=\"get\">");
        printWriter.write("<input type=\"text\" name=\"username\"><br/>");
        printWriter.write("<input type=\"password\" name=\"password\"><br/>");
        printWriter.write("<input type=\"submit\" value=\"登录\">");
        printWriter.write("</form>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}

package com.bobo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyService {
    public static void startService(int port) throws Exception{
        //服务器端套接字
        ServerSocket serverSocket=new ServerSocket(port);
        //客户端套接字
        Socket socket=null;
        while (true){
            socket=serverSocket.accept();

            //输入输出流
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();

            //初始化请求响应类
            MyRequest myRequest=new MyRequest(inputStream);
            MyResponse myResponse=new MyResponse(outputStream);

            //找到合适的applet
            String classString = MyMapping.getMapping().get(myRequest.getRequestUrl());
            System.out.println(classString);
            if (classString!=null){
                Class<MyHttpServlet> clazz=(Class<MyHttpServlet>) Class.forName(classString);
                MyHttpServlet myHttpServlet=clazz.newInstance();
                myHttpServlet.service(myRequest,myResponse);
            }
        }
    }

    public static void main(String[] args) {
        try {
            startService(10087);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

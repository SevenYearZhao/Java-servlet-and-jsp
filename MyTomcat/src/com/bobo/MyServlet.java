package com.bobo;

public class MyServlet extends MyHttpServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("MyTomcat Get");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("MyTomcat Post");
    }
}

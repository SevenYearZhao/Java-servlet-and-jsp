package com.bobo;

public abstract class MyHttpServlet {

    private static final String REQUEST_GET="GET";
    private static final String REQUEST_POST="POST";

    public abstract void doGet(MyRequest request,MyResponse response) throws Exception;
    public abstract void doPost(MyRequest request,MyResponse response) throws Exception;

    public void service(MyRequest request,MyResponse response) throws Exception{
        if (REQUEST_GET.equals(request.getRequestType())){
            doGet(request,response);
        }else {
            doPost(request,response);
        }
    }
}

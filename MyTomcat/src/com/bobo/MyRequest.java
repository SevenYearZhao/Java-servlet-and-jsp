package com.bobo;

import java.io.InputStream;

public class MyRequest {
    //客户端请求类型
    private String requestType;
    //客户端请求URL
    private String requestUrl;

    public MyRequest(InputStream inputStream) throws Exception {
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String text = new String(bytes, 0, len);
        String firstLine = text.split("\n")[0];
        String[] firstTextArray = firstLine.split(" ");
        this.requestType = firstTextArray[0];
        this.requestUrl = firstTextArray[1];
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}

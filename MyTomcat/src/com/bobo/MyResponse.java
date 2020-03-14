package com.bobo;

import java.io.OutputStream;

public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws Exception{
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("HTTP/1.0 200 ok\n")
                .append("Context-type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>"+str+"</h1>")
                .append("</body>")
                .append("</html>");
        outputStream.write(stringBuilder.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }
}

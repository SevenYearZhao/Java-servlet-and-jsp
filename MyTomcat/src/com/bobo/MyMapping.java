package com.bobo;

import java.util.HashMap;

public class MyMapping {
    public static HashMap<String,String> mapping=new HashMap<>();
    static {
        mapping.put("/myTomcat","com.bobo.MyServlet");
   }
   public static HashMap<String,String> getMapping(){
        return mapping;
   }
}

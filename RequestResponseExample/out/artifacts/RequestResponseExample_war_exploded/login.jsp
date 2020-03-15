<%--
  Created by IntelliJ IDEA.
  User: zhaosongbo
  Date: 2020/3/15
  Time: 1:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="bobo" method="get">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="pwd"/><br/>
        爱好：<br/>
        <input type="checkbox" name="fav" value="1"/>java
        <input type="checkbox" name="fav" value="1"/>c
        <input type="checkbox" name="fav" value="1"/>c++
<input type="submit" value="登录"/>
</form>
</body>
</html>

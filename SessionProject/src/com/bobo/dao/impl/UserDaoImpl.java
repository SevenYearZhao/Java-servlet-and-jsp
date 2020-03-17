package com.bobo.dao.impl;

import com.bobo.dao.UserDao;
import com.bobo.entry.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(User user) {

        //定义链接对象
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
            //获取预处理块
            statement = conn.prepareStatement("select * from user where name = ? and pwd = ?");
            //给？赋值
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            //执行sql语句
            resultSet = statement.executeQuery();
            //从result中获取结果
            while (resultSet.next()) {
                u = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return u;
    }
}

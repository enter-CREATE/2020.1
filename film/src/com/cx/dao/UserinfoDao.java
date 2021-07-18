package com.cx.dao;

import com.cx.entity.Userinfo;
import com.cx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserinfoDao {
    public Userinfo selectByPhoneAndPwd(String phone, String pwd) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Userinfo userinfo = null;
        try {
            String sql = "select * from userinfo where phone=? and pwd=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userinfo = new Userinfo();
                userinfo.setId(resultSet.getInt(1));
                userinfo.setPhone(resultSet.getString(2));
                userinfo.setNickname(resultSet.getString(3));
                userinfo.setPwd(resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, resultSet);
        }
        return userinfo;
    }
}

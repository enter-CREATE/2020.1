package com.cx.util;

import java.sql.*;

public class JdbcUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2  alt + enter 导包    获取到mysql数据库的连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkddb",
                    "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeAllResource(Connection connection, Statement statement, ResultSet resultSet) {
        closeResource(resultSet);
        closeResource(statement);
        closeResource(connection);
    }

    private static void closeResource(AutoCloseable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

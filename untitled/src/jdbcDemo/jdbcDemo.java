package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 1.加载驱动（mysql）
 * 2.获取连接  与mysql
 * 3，获取语句对象  PreparedStatement
 * 4.执行SQL语句
 * 5，处理执行结果
 * 6.关闭连接 语句对象 结果集  关闭顺序：后打开先关闭
 */
public class jdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1
        Class.forName("com.mysql.jdbc.Driver");

        // 2  alt + enter 导包    获取到mysql数据库的连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkddb",
                "root", "123456");
        // 3
        PreparedStatement preparedStatement = connection.prepareStatement(" insert into student values(\"lisi\",21);");

        // 4 增删改 executeUpdate   查询  executeQuery
//        preparedStatement.executeQuery()
        int affectedRows = preparedStatement.executeUpdate();
        // 5. 增删改   返回一个整数，表示sql语句改变的行数   查询 返回一个结果集，表示查询到的数据
        if (affectedRows > 0) {
            System.out.println("插入数据成功");
        } else {
            System.out.println("插入数据失败");
        }
        // 6 关闭资源
        preparedStatement.close();
        connection.close();

    }

}
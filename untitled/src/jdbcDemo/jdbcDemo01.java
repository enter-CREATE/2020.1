package jdbcDemo;

import java.sql.*;

public class jdbcDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkddb",
                "root","123456");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        // 返回查询的记录-》结果集resultSet
        ResultSet resultSet = preparedStatement.executeQuery();
        // 遍历结果集，得到查询的数据
        while (resultSet.next()){
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + " " + age);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}

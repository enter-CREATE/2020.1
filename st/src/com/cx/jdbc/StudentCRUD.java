package com.cx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCRUD {
    /**
     * 增加
     * @param student
     * @return
     */
    public int insertStudent(Student student){
        // 获取数据库连接
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        // 要执行的SQL语句  ?占位符-》待插入数据
        String sql = "insert into student values(?,?,?,?)";
        try {
            // 获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            // 执行SQL语句之前设置占位符内容  1，2，3，4表示问号的顺序
            // ？的顺序是与表对应的
            preparedStatement.setObject(1,student.getName());
            preparedStatement.setObject(2,student.getSex());
            preparedStatement.setObject(3,student.getId());
            preparedStatement.setObject(4,student.getAge());
            // 执行SQL语句
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 根据Name列删除对应的信息
     * @param Name
     * @return
     */
    public int deleteByName(String Name){
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "delete from student where name=?";

        // 获取PreparedStatement对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, Name);
            // 执行SQL语句
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    /**
     * 更新信息
     * @param student
     * @return
     */
    public int updateByName(Student student){
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "update student set sex=?,id=?,age=? where name=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,student.getSex());
            preparedStatement.setObject(2,student.getId());
            preparedStatement.setObject(3,student.getAge());
            preparedStatement.setObject(4,student.getName());
            // 执行SQL语句
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    /**
     * 查询所有的学生
     * @return
     */
    public List<Student> selectAll(){
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        List<Student> studentList = new ArrayList<>();

        String sql = "select * from student";
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 执行SQL查询，返回结果集  查询出来的是多行数据
            ResultSet resultSet = preparedStatement.executeQuery();
            // 对结果集进行遍历  一次循环遍历出来的是一行数据
            while(resultSet.next()){

                Student student = new Student();

                String name = resultSet.getString("name");

                student.setName(name);
                String  sex = resultSet.getString("sex");

                student.setSex(sex);
                String id = resultSet.getString("id");

                student.setId(id);
                int age = resultSet.getInt("age");

                student.setAge(age);
                studentList.add(student);
            }

            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public Student selectByName(String Name){
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "select * from student where name=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 执行SQL查询，返回结果集  查询出来的是多行数据
            ResultSet resultSet = preparedStatement.executeQuery();
            // 对结果集进行遍历  一次循环遍历出来的是一行数据
            while(resultSet.next()){

                Student student=new Student();

                String name = resultSet.getString("name");
                student.setName(name);

                String sex=resultSet.getString("sex");
                student.setSex(sex);

                String id=resultSet.getString("id");
                student.setId(id);

                int age=resultSet.getInt("age");
                student.setAge(age);

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}

package com.cx.dao;

import com.cx.entity.Film;
import com.cx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilmDao {
    public List<Film> selectAll() {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Film> filmList = null;

        try {
            String sql = "select * from filminfo";
            preparedStatement = connection.prepareStatement(sql);
            //执行查询
            resultSet = preparedStatement.executeQuery();

            filmList = new ArrayList<>();
            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt(1));
                film.setUkName(resultSet.getString(2));
                film.setNickName(resultSet.getString(3));
                film.setTinyImg(resultSet.getString(4));
                film.setAttackPower(resultSet.getInt(5));
                film.setHandHard(resultSet.getInt(6));
                filmList.add(film);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, resultSet);
        }
        return filmList;
    }

    public int delFilmById(int id) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String sql = "delete from filminfo where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, null);
        }
        return 0;

    }

    public int insertFilm(Film film) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String sql = "insert into filminfo values(null, ?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getUkName());
            preparedStatement.setString(2, film.getNickName());
            preparedStatement.setString(3, film.getTinyImg());
            preparedStatement.setInt(4, film.getAttackPower());
            preparedStatement.setInt(5, film.getHandHard());
            // 执行sql语句，删除对应的id元素，如果删除成功，则返回1
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, null);
        }
        return 0;
    }

    public Film selectById(int id) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from filminfo where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt(1));
                film.setUkName(resultSet.getString(2));
                film.setNickName(resultSet.getString(3));
                film.setTinyImg(resultSet.getString(4));
                film.setAttackPower(resultSet.getInt(5));
                film.setHandHard(resultSet.getInt(6));
                return film;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, resultSet);
        }
        return null;
    }

    public int updateById(Film film) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String sql = "update filminfo set uk_name=?,nickname=?,tiny_img=?,attack_power=?,hand_hard=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getUkName());
            preparedStatement.setString(2, film.getNickName());
            preparedStatement.setString(3, film.getTinyImg());
            preparedStatement.setInt(4, film.getAttackPower());
            preparedStatement.setInt(5, film.getHandHard());
            preparedStatement.setInt(6, film.getId());
            // 执行sql语句，删除对应的id元素，如果删除成功，则返回1
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, null);
        }
        return 0;
    }
}

package com.cx.dao;

import com.cx.entity.Hero;
import com.cx.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 完成英雄表信息的增删查改功能
 */
public class HeroDao {

    public List<Hero> selectAll(){
        Connection connection= JdbcUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Hero> heroList=null;

        try{
            String sql="select * from lolhero";
            preparedStatement=connection.prepareStatement(sql);
            //执行查询
            resultSet=preparedStatement.executeQuery();

            heroList=new ArrayList<>();
            while (resultSet.next()){
                Hero hero=new Hero();
                hero.setId(resultSet.getInt(1));
                hero.setUkName(resultSet.getString(2));
                hero.setNickName(resultSet.getString(3));
                hero.setTinyImg(resultSet.getString(4));
                hero.setAttackPower(resultSet.getInt(5));
                hero.setHandHard(resultSet.getInt(6));
                heroList.add(hero);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            JdbcUtil.closeAllResource(connection,preparedStatement,resultSet);
        }
        return heroList;
    }

    public  int delHeroById(int id){
        Connection connection= JdbcUtil.getConnection();
        PreparedStatement preparedStatement=null;

        try{
            String sql="delete from lolhero where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            JdbcUtil.closeAllResource(connection,preparedStatement,null);
        }
        return 0;

    }

    public int insertHero(Hero hero){
        Connection  connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String sql = "insert into lolhero values(null, ?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hero.getUkName());
            preparedStatement.setString(2,hero.getNickName());
            preparedStatement.setString(3,hero.getTinyImg());
            preparedStatement.setInt(4,hero.getAttackPower());
            preparedStatement.setInt(5,hero.getHandHard());
            // 执行sql语句，删除对应的id元素，如果删除成功，则返回1
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, null);
        }
        return 0;
    }

    public Hero selectById(int id){
        Connection  connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from lolhero where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Hero hero = new Hero();
                hero.setId(resultSet.getInt(1));
                hero.setUkName(resultSet.getString(2));
                hero.setNickName(resultSet.getString(3));
                hero.setTinyImg(resultSet.getString(4));
                hero.setAttackPower(resultSet.getInt(5));
                hero.setHandHard(resultSet.getInt(6));
                return hero;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeAllResource(connection, preparedStatement, resultSet);
        }
        return null;
    }

    public int updateById(Hero hero){
        Connection  connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String sql = "update lolhero set uk_name=?,nickname=?,tiny_img=?,attack_power=?,hand_hard=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hero.getUkName());
            preparedStatement.setString(2,hero.getNickName());
            preparedStatement.setString(3,hero.getTinyImg());
            preparedStatement.setInt(4,hero.getAttackPower());
            preparedStatement.setInt(5,hero.getHandHard());
            preparedStatement.setInt(6,hero.getId());
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

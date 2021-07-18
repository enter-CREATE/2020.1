import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroCRUD {
    public int insertHero(Hero hero) {
        // 获取数据库连接
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        // 要执行的SQL语句  ?占位符-》待插入数据
        String sql = "insert into hero values(?,?,?,?)";
        try {
            // 获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            // 执行SQL语句之前设置占位符内容  1，2，3，4表示问号的顺序
            // ？的顺序是与表对应的
            preparedStatement.setObject(1, hero.getUk_name());
            preparedStatement.setObject(2, hero.getNickname());
            preparedStatement.setObject(3, hero.getTing_img());
            preparedStatement.setObject(4, hero.getHand_hard());
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
     * 根据unName列删除对应的英雄信息
     *
     * @param ukName
     * @return
     */
    public int deleteByUkName(String ukName) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "delete from hero where uk_name=?";

        // 获取PreparedStatement对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, ukName);
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
     * 更具ukName更新英雄信息
     *
     * @param hero
     * @return
     */
    public int updateByUkName(Hero hero) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "update hero set nickname=?,tiny_img=?,hand_hard=? where uk_name=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, hero.getNickname());
            preparedStatement.setObject(2, hero.getTing_img());
            preparedStatement.setObject(3, hero.getHand_hard());
            preparedStatement.setObject(4, hero.getUk_name());
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
     * 查询所有的英雄
     *
     * @return
     */
    public List<Hero> selectAll() {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;

        List<Hero> heroList = new ArrayList<>();

        String sql = "select * from hero";
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 执行SQL查询，返回结果集  查询出来的是多行数据
            ResultSet resultSet = preparedStatement.executeQuery();
            // 对结果集进行遍历  一次循环遍历出来的是一行数据
            while (resultSet.next()) {
                // 遍历一行就是一个英雄，创建一个英雄，用于保存查到的当前行影响
                Hero hero = new Hero();
                // 获取每一行数据展示  根据表中的列明获取每一列数据
                String uk_name = resultSet.getString("uk_name");
                // 为英雄设置uk name
                hero.setUk_name(uk_name);
                String nickName = resultSet.getString("nickname");
                //  为英雄设置nickName
                hero.setNickname(nickName);
                String tiny_img = resultSet.getString("tiny_img");
                hero.setTing_img(tiny_img);
                int hand_hard = resultSet.getInt("hand_hard");
                hero.setHand_hard(hand_hard);
                // 把获取的这个影响添加到集合中
                heroList.add(hero);
            }

            return heroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}

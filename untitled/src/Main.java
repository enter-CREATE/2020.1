import java.util.List;

public class Main {
    // 应用程序的入口
    public static void main(String[] args) {
        insertHero();
        // updateHero();
        //deleteHero();
        //selectAll();
    }

    /**
     * 写什么样的代码能有什么样的效果
     */
    public static void insertHero() {
        // 创建一个英雄  new新建/创建
        Hero hero = new Hero();
        // 为这个英雄赋予相关属性
        hero.setUk_name("黑暗之女");
        hero.setNickname("安妮");
        hero.setTing_img("https://ossweb-img.qq.com/images/lol/img/champion/Annie.png");
        hero.setHand_hard(7);
        // 调用方法将这个英雄插入数据库
        // 创建一个HeroCRUD对象
        HeroCRUD heroCRUD = new HeroCRUD();
        // 调用对象的插入英雄方法
        int affectedRows = heroCRUD.insertHero(hero);
        if (affectedRows > 0) {
            System.out.println("插入数据成功");
        } else {
            System.out.println("插入数据失败");
        }
    }

    public static void updateHero() {
        Hero hero = new Hero();
        // 为这个英雄赋予相关属性
        hero.setUk_name("黑暗之女");
        hero.setNickname("安其拉");
        hero.setTing_img("https://ossweb-img.qq.com/images/lol/img/champion/Annie.png");
        hero.setHand_hard(8);

        HeroCRUD heroCRUD = new HeroCRUD();
        int affectedRows = heroCRUD.updateByUkName(hero);
        if (affectedRows > 0) {
            System.out.println("更新数据成功");
        } else {
            System.out.println("更新数据失败");
        }
    }

    public static void deleteHero() {
        String ukName = "黑暗之女";
        HeroCRUD heroCRUD = new HeroCRUD();
        int affectedRows = heroCRUD.deleteByUkName(ukName);

        if (affectedRows > 0) {
            System.out.println("删除数据成功");
        } else {
            System.out.println("删除数据失败");
        }
    }

    /**
     * 查询所有英雄
     */
    public static void selectAll() {
        HeroCRUD heroCRUD = new HeroCRUD();
        List<Hero> heroList = heroCRUD.selectAll();
        // 遍历英雄列表并输出每一个英雄信息
        heroList.forEach(System.out::println);
    }

}

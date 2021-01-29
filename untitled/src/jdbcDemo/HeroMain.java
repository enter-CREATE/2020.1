package jdbcDemo;

import jdbcDemo.Hero;

import java.util.List;
import java.util.ArrayList;

public class HeroMain {
    public static void main(String[] args) {

        System.out.println("游戏开始");

        List<Hero> heroes = new ArrayList();
        // 双方选择的英雄创建
        // 红方  new 创建
        Hero hero1 = new Hero();
        hero1.setName("王昭君");
        hero1.setBelong("红方");
        hero1.setBlood(1000);

        heroes.add(hero1);
        // set继续，把所有的都可以set一次
        Hero hero2 = new Hero();
        hero2.setName("杨玉环");
        hero2.setBelong("红方");
        hero2.setBlood(1100);
        heroes.add(hero2);


        Hero hero5 = new Hero();
        hero5.setName("黄忠");
        hero5.setLevel(4);
        hero5.setBelong("蓝方");

        heroes.add(hero5);
        // .....
        Hero hero6 = new Hero();
        hero6.setName("关羽");
        hero6.setLevel(4);
        hero6.setBelong("蓝方");
        heroes.add(hero6);
        // .....

        for(int i = 0; i < heroes.size(); i++) {
            // 找到蓝方英雄并输出
            Hero hero = heroes.get(i);

            System.out.println(hero.getName());
            System.out.println(hero.getBelong());

        }


    }
}

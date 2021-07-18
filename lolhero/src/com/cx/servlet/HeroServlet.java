package com.cx.servlet;

import com.cx.dao.HeroDao;
import com.cx.entity.Hero;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HeroServlet", urlPatterns = "/hero")
public class HeroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String operator = request.getParameter("operator");
        HeroDao heroDao = new HeroDao();

        if ("selectall".equals(operator)) {
            //查询所有英雄数据->>跳转页面展示
            List<Hero> heroList = heroDao.selectAll();
            HttpSession session = request.getSession();
            session.setAttribute("heroes", heroList);
            //跳转页面展示
            response.sendRedirect("/lolhero/hero.jsp");
        } else if ("delete".equals(operator)) {
            String id = request.getParameter("id");
            // Integer.parseInt(id) -> 将id转换成整数
            int affectedRows = heroDao.delHeroById(Integer.parseInt(id));
            if (affectedRows > 0) {
                // 删除成功，继续回去显示所有存在的数据
                response.sendRedirect("/lolhero/hero?operator=selectall");
            } else {
                response.getWriter().write("删除失败");
            }
        } else if ("add".equals(operator)) {
            String ukName = request.getParameter("ukname");
            String nickname = request.getParameter("nickname");
            String tinyImg = request.getParameter("tinyimg");
            String attackPower = request.getParameter("attackpower");
            String handHard = request.getParameter("handhard");

            Hero hero = new Hero();
            hero.setUkName(ukName);
            hero.setNickName(nickname);
            hero.setTinyImg(tinyImg);
            hero.setAttackPower(Integer.parseInt(attackPower)); // 字符串转换成整数Integer.parseInt
            hero.setHandHard(Integer.parseInt(handHard));

            int affectedRows = heroDao.insertHero(hero);

            if (affectedRows > 0) {
                // 插入成功，继续回去显示所有存在的数据
                response.sendRedirect("/lolhero/hero?operator=selectall");
            } else {
                response.getWriter().write("插入失败");
            }
        } else if ("selectbyid".equals(operator)) {
            String id = request.getParameter("id");
            Hero hero = heroDao.selectById(Integer.parseInt(id));
            // 将英雄信息存入session中
            HttpSession session = request.getSession();
            session.setAttribute("hero", hero);
            response.sendRedirect("/lolhero/update.jsp");
        } else if ("update".equals(operator)) {
            String id = request.getParameter("code");
            String ukName = request.getParameter("ukname");
            String nickname = request.getParameter("nickname");
            String tinyImg = request.getParameter("tinyimg");
            String attackPower = request.getParameter("attackpower");
            String handHard = request.getParameter("handhard");

            Hero hero = new Hero();
            hero.setId(Integer.parseInt(id));
            hero.setUkName(ukName);
            hero.setNickName(nickname);
            hero.setTinyImg(tinyImg);
            hero.setAttackPower(Integer.parseInt(attackPower)); // 字符串转换成整数Integer.parseInt
            hero.setHandHard(Integer.parseInt(handHard));

            int affectedRows = heroDao.updateById(hero);

            if (affectedRows > 0) {
                // 修改成功，继续回去显示所有存在的数据
                response.sendRedirect("/lolhero/hero?operator=selectall");
            } else {
                response.getWriter().write("修改失败");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

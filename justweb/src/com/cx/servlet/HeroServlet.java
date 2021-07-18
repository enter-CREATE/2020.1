package com.cx.servlet;

import com.cx.jdbc.Hero;
import com.cx.jdbc.HeroCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HeroServlet", urlPatterns = "/showhero")
public class HeroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询英雄信息
        HeroCRUD heroCRUD = new HeroCRUD();
        List<Hero> heroList = heroCRUD.selectAll();
        // 查询到数据之后，将数据保存到Session中
        // 获取session对象
        HttpSession session = request.getSession();
        // 将数据保存到session中
        session.setAttribute("heros", heroList);
        // 重定向 从当前servlet跳到 showhero.jsp页面进行展示，自发行为
        // 只需补全代码
        // jsp页面->浏览器中展示数据
        response.sendRedirect("/justweb/showhero.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

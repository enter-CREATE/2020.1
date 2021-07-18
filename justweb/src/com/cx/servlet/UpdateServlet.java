package com.cx.servlet;

import com.cx.jdbc.Hero;
import com.cx.jdbc.HeroCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = "/updatehero")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        // getParameter("ukName")中的ukName一定是要与input标签的name值相同
        String uk_name = request.getParameter("uk_name");
        String nickname = request.getParameter("nickname");
        String ting_img = request.getParameter("ting_img");
        String hand_hard = request.getParameter("hand_hard");
        // 以上就是用于获取在网页上输入的信息

        Hero hero = new Hero();
        hero.setUk_name(uk_name);
        hero.setNickname(nickname);
        hero.setTing_img(ting_img);
        // Integer.parseInt(handHard) -》 将字符串数值handHard转换成整数值
        hero.setHand_hard(Integer.parseInt(hand_hard));

        HeroCRUD heroCRUD = new HeroCRUD();
        int isSuccess = heroCRUD.updateByUkName(hero);

        if (isSuccess > 0) {
            response.getWriter().write("Success");
        } else {
            response.getWriter().write("fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

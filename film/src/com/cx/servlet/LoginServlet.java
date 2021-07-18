package com.cx.servlet;

import com.cx.dao.UserinfoDao;
import com.cx.entity.Userinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");

        UserinfoDao userinfoDao = new UserinfoDao();
        Userinfo userinfo = userinfoDao.selectByPhoneAndPwd(phone, pwd);
        if (null == userinfo) {
            //不存在(登录失败)
            response.sendRedirect("/filminfo/login.jsp");
        } else {
            //登录成功,获取session对象存储当前登录用户
            HttpSession session = request.getSession();
            session.setAttribute("user", userinfo);
            //到首页展示-->先到servlet中获取数据，在跳转到jsp页面展示
            response.sendRedirect("/filminfo/film?operator=selectall");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

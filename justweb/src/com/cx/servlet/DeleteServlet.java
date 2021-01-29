package com.cx.servlet;

import com.cx.jdbc.HeroCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delhero")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取输入的ukName值
        String uk_name=request.getParameter("uk_name");
        HeroCRUD heroCRUD=new HeroCRUD();
        int Success = heroCRUD.deleteByUkName("uk_name");
        if(Success>0){
            response.getWriter().write("Success");
        }else{
            response.getWriter().write("fail");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

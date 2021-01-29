package com.cx.servlet;

import com.cx.jdbc.Student;
import com.cx.jdbc.StudentCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet",urlPatterns = "/addstudent")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String  name =request.getParameter("name");
        String  sex =request.getParameter("sex");
        String  id =request.getParameter("id");
        String  age =request.getParameter("age");

        Student student=new Student();
        student.setName(name);
        student.setSex(sex);
        student.setId(id);
        student.setAge(Integer.parseInt(age));

        StudentCRUD studentCRUD=new StudentCRUD();
        int isSuccess = studentCRUD.insertStudent(student);

        if(isSuccess>0){
            response.getWriter().write("Success");
        }else{
            response.getWriter().write("fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

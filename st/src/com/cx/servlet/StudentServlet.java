package com.cx.servlet;

import com.cx.jdbc.Student;
import com.cx.jdbc.StudentCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/showstudent")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentCRUD studentCRUD = new StudentCRUD();
        List<Student> studentList = studentCRUD.selectAll();

        HttpSession session = request.getSession();

        session.setAttribute("students", studentList);
        response.sendRedirect("/st/showstudent.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

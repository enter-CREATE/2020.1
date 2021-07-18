package com.cx.servlet;

import com.cx.jdbc.Student;
import com.cx.jdbc.StudentCRUD;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CRUDServlet", urlPatterns = "/studentcrud")
public class CRUDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String operator = request.getParameter("operator");
        // CRUD->通过一个参数去辨别进行得是哪个操作，这样的话，同一个Servlet就可以
        // 去完成增删查改功能了
        if ("add".equals(operator)) {
            // 添加
            add(request, response);
        } else if ("delete".equals(operator)) {
            // 删除
            delete(request, response);
        } else if ("update".equals(operator)) {
            // 修改
            update(request, response);
        } else if ("selectall".equals(operator)) {
            // 查询
            selectAll(request, response);
        } else if ("selectbyName".equals(operator)) {
            selectByName(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String id = request.getParameter("id");
        String age = request.getParameter("age");
        // 以上就是用于获取在网页上输入的信息

        Student student = new Student();
        student.setName(name);
        student.setSex(sex);
        student.setId(id);
        student.setAge(Integer.parseInt(age));

        StudentCRUD studentCRUD = new StudentCRUD();
        int isSuccess = studentCRUD.insertStudent(student);

        if (isSuccess > 0) {
            response.getWriter().write("Success");
        } else {
            response.getWriter().write("fail");
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String id = request.getParameter("id");
        String age = request.getParameter("age");

        Student student = new Student();
        student.setName(name);
        student.setSex(sex);
        student.setId(id);
        student.setAge(Integer.parseInt(age));

        StudentCRUD studentCRUD = new StudentCRUD();
        int isSuccess = studentCRUD.updateByName(student);

        if (isSuccess > 0) {
            response.getWriter().write("Success");
        } else {
            response.getWriter().write("fail");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");

        StudentCRUD studentCRUD = new StudentCRUD();

        int Success = studentCRUD.deleteByName("name");
        if (Success > 0) {
            response.sendRedirect("/st/studentcrud?operator=selectall");
        } else {
            response.getWriter().write("fail");
        }
    }

    public void selectByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        StudentCRUD studentCRUD = new StudentCRUD();
        Student student = studentCRUD.selectByName(name);
        HttpSession session = request.getSession();
        session.setAttribute("student", student);
        response.sendRedirect("/st/updatestudent.jsp");
    }

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentCRUD studentCRUD = new StudentCRUD();
        List<Student> studentList = studentCRUD.selectAll();

        HttpSession session = request.getSession();

        session.setAttribute("students", studentList);
        response.sendRedirect("/st/showstudent.jsp");
    }

}

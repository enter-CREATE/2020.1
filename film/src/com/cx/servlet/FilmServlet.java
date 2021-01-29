package com.cx.servlet;

import com.cx.dao.FilmDao;
import com.cx.entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FilmServlet",urlPatterns = "/film")
public class FilmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String operator = request.getParameter("operator");
        FilmDao filmDao=new FilmDao();

        if("selectall".equals(operator)){
            //查询所有数据->>跳转页面展示
            List<Film> filmList=filmDao.selectAll();
            HttpSession session=request.getSession();
            session.setAttribute("films",filmList);
            //跳转页面展示
            response.sendRedirect("/filminfo/film.jsp");
        } else if("delete".equals(operator)){
            String id = request.getParameter("id");
            // Integer.parseInt(id) -> 将id转换成整数
            int affectedRows = filmDao.delFilmById(Integer.parseInt(id));
            if(affectedRows > 0) {
                // 删除成功，继续回去显示所有存在的数据
                response.sendRedirect("/filminfo/film?operator=selectall");
            } else {
                response.getWriter().write("删除失败");
            }
        }else if("add".equals(operator)){
            String ukName = request.getParameter("ukname");
            String nickname = request.getParameter("nickname");
            String tinyImg = request.getParameter("tinyimg");
            String attackPower = request.getParameter("attackpower");
            String handHard = request.getParameter("handhard");

            Film film=new Film();
            film.setUkName(ukName);
            film.setNickName(nickname);
            film.setTinyImg(tinyImg);
            film.setAttackPower(Integer.parseInt(attackPower)); // 字符串转换成整数Integer.parseInt
            film.setHandHard(Integer.parseInt(handHard));

            int affectedRows = filmDao.insertFilm(film);

            if(affectedRows > 0) {
                // 修改成功，继续回去显示所有存在的数据
                response.sendRedirect("/filminfo/film?operator=selectall");
            } else {
                response.getWriter().write("添加失败");
            }
        }else if ("selectbyid".equals(operator)){
            String id = request.getParameter("id");
            Film film = filmDao.selectById(Integer.parseInt(id));
            // 将英雄信息存入session中
            HttpSession session = request.getSession();
            session.setAttribute("film", film);
            response.sendRedirect("/filminfo/update.jsp");
        }else if("update".equals(operator)){
            String id = request.getParameter("code");
            String ukName = request.getParameter("ukname");
            String nickname = request.getParameter("nickname");
            String tinyImg = request.getParameter("tinyimg");
            String attackPower = request.getParameter("attackpower");
            String handHard = request.getParameter("handhard");

            Film film=new Film();
            film.setId(Integer.parseInt(id));
            film.setUkName(ukName);
            film.setNickName(nickname);
            film.setTinyImg(tinyImg);
            film.setAttackPower(Integer.parseInt(attackPower)); // 字符串转换成整数Integer.parseInt
            film.setHandHard(Integer.parseInt(handHard));

            int affectedRows = filmDao.updateById(film);

            if(affectedRows > 0) {
                // 修改成功，继续回去显示所有存在的数据
                response.sendRedirect("/filminfo/film?operator=selectall");
            } else {
                response.getWriter().write("修改失败");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}

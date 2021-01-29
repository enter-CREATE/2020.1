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

@WebServlet(name = "CRUDServlet",urlPatterns = "/herocrud")
public class CRUDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String operator = request.getParameter("operator");
        // CRUD->通过一个参数去辨别进行得是哪个操作，这样的话，同一个Servlet就可以
        // 去完成增删查改功能了
        if("add".equals(operator)){
            // 添加英雄
            add(request,response);
        } else if("delete".equals(operator)){
            // 删除英雄
            delete(request,response);
        } else if("update".equals(operator)){
            // 修改英雄
            update(request,response);
        } else if("selectall".equals(operator)){  // herocrud?operator=selectall
            // 查询所有英雄
            selectAll(request,response);
        }else if ("selectbyukname".equals(operator)){
            selectByUkName(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // getParameter("ukName")中的ukName一定是要与input标签的name值相同
        String  uk_name =request.getParameter("uk_name");
        String  nickname =request.getParameter("nickname");
        String  ting_img =request.getParameter("ting_img");
        String  hand_hard =request.getParameter("hand_hard");
        // 以上就是用于获取在网页上输入的信息

        Hero hero=new Hero();
        hero.setUk_name(uk_name);
        hero.setNickname(nickname);
        hero.setTing_img(ting_img);
        // Integer.parseInt(handHard) -》 将字符串数值handHard转换成整数值
        hero.setHand_hard(Integer.parseInt(hand_hard));

        HeroCRUD heroCRUD=new HeroCRUD();
        int isSuccess = heroCRUD.insertHero(hero);

        if(isSuccess > 0) {
            // alt + enter ->点击第一个  解决错误
            response.getWriter().write("Success");
        } else {
            response.getWriter().write("fail");
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // getParameter("ukName")中的ukName一定是要与input标签的name值相同
        String  uk_name =request.getParameter("uk_name");
        String  nickname =request.getParameter("nickname");
        String  ting_img =request.getParameter("ting_img");
        String  hand_hard =request.getParameter("hand_hard");
        // 以上就是用于获取在网页上输入的信息

        Hero hero=new Hero();
        hero.setUk_name(uk_name);
        hero.setNickname(nickname);
        hero.setTing_img(ting_img);
        // Integer.parseInt(handHard) -》 将字符串数值handHard转换成整数值
        hero.setHand_hard(Integer.parseInt(hand_hard));


        HeroCRUD heroCRUD= new HeroCRUD();
        int isSuccess = heroCRUD.updateByUkName(hero);

        if(isSuccess > 0) {
            response.getWriter().write("Success");
        } else {
            response.getWriter().write("fail");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取输入的ukName值
        String uk_name=request.getParameter("uk_name");
        HeroCRUD heroCRUD=new HeroCRUD();
        int success = heroCRUD.deleteByUkName("uk_name");
        if(success > 0){
            // 删除成功，跳回去再次查询所有数据进行展示
            response.sendRedirect("/justweb/herocrud?operator=selectall");
        } else {
            response.getWriter().write("fail");
        }
    }

    public void selectByUkName(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String uk_name=request.getParameter("uk_name");
        HeroCRUD heroCRUD=new HeroCRUD();
        Hero hero=heroCRUD.selectByUkName(uk_name);
        HttpSession session=request.getSession();
        session.setAttribute("hero",hero);
        response.sendRedirect("/justweb/updatehero.jsp");
    }

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
}

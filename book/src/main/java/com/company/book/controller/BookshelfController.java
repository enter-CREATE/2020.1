package com.company.book.controller;

import com.company.book.dataobject.Bookshelf;
import com.company.book.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/bookshelf")
public class BookshelfController {
    @Autowired
    private BookshelfService bookshelfService;

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object>map){
        List<Bookshelf> list=bookshelfService.findUpAll();
        map.put("bookshelfList",list);
        return new ModelAndView("bookshelf/list",map);
    }

    @RequestMapping(value = "select")
    //模糊查询
    public String select(Model model, HttpServletRequest request){
        String bookName=request.getParameter("bookName");
        List<Bookshelf> unit=bookshelfService.findByName(bookName);
        model.addAttribute("unit",unit);
        return "bookshelf/select";
    }
}

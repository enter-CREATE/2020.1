package com.company.book.service;

import com.company.book.dataobject.Bookshelf;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookshelfService {
    //查询一本书
    Bookshelf findone(String bookId);
    //查找所有
    List<Bookshelf> findUpAll();
    //通过书名查询
    List<Bookshelf> findByName(@Param("bookName") String bookName);
}

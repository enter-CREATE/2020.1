package com.company.book.service.impl;

import com.company.book.dataobject.Bookshelf;
import com.company.book.repository.BookshelfRepository;
import com.company.book.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfServiceImpl implements BookshelfService {
    @Autowired
    BookshelfRepository repository;
    @Override
    //查询一本书
    public Bookshelf findone(String bookId){
        return (Bookshelf) repository.findById(bookId).orElse(null);
    }
    @Override
    //查找所有
    public List<Bookshelf> findUpAll(){
        return repository.findAll();
    }
    @Override
    //通过书名查询
    public List<Bookshelf> findByName(@Param("bookName") String bookName){
        return repository.findByName(bookName);
    }
}

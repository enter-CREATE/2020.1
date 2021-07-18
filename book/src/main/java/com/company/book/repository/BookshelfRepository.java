package com.company.book.repository;

import com.company.book.dataobject.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookshelfRepository extends JpaRepository<BookshelfRepository,String> {
    @Query(value = "select * from bookshelf where bookName like CONCAT('%',:bookName,'%')",nativeQuery = true)
    List<Bookshelf> findByName(@Param("bookName") String bookName);

}

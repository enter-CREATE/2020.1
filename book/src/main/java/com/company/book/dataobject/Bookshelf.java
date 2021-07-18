package com.company.book.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 书架
 */
@Entity
@Data
public class Bookshelf {
    @Id
    private String bookId;//编号
    private String bookName;//书名
    private String author;//作者
    private String introduction;//简介
    private String image;//图片
    private String publishing;//出版
}

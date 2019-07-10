package com.oaec.springmvc.service;

import com.oaec.springmvc.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> books();
    Boolean addBook(Book book);
    Book queryBuId(Integer bookId);
    Boolean deleteBook(Integer bookId);
    Boolean save(Book book);
}

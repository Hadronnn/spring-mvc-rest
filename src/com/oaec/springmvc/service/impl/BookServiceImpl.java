package com.oaec.springmvc.service.impl;

import com.oaec.springmvc.dao.BookDao;
import com.oaec.springmvc.entity.Book;
import com.oaec.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public List<Book> books() {
        return bookDao.queryAll();
    }

    @Override
    public Boolean addBook(Book book) {
        return bookDao.doInsert(book) == 1;
    }

    @Override
    public Book queryBuId(Integer bookId) {
        return bookDao.QueryById(bookId);
    }

    @Override
    public Boolean deleteBook(Integer bookId) {
        return bookDao.doDelete(bookId) == 1;
    }

    @Override
    public Boolean save(Book book) {
        return bookDao.doUpdate(book)==1;
    }
}

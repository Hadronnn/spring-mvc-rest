package com.oaec.springmvc.dao.impl;

import com.oaec.springmvc.dao.BookDao;
import com.oaec.springmvc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int doInsert(Book book) {
        String sql = "INSERT INTO book (name,author,price) VALUES(?,?,?)";
        int i = jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice());
        return i;
    }

    @Override
    public int doDelete(Integer bookId) {
        String sql = "DELETE FROM book WHERE book_id = ?";
        int i = jdbcTemplate.update(sql, bookId);
        return i;
    }

    @Override
    public int doUpdate(Book book) {
        String sql = "UPDATE book SET name=?,author=?,price=? WHERE book_id=?";
        return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getBookId());
    }

    @Override
    public List<Book> queryAll() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book QueryById(Integer bookId) {
        String sql = "SELECT * FROM book WHERE book_id = ?";
        List<Book> query = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class), bookId);
        return query.get(0);
    }

}

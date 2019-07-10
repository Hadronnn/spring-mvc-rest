package com.oaec.springmvc.controller;

import com.oaec.springmvc.entity.Book;
import com.oaec.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String books(Model model){
        List<Book> books = bookService.books();
        model.addAttribute("books",books);
        return "books";
    }
    @GetMapping("/book")
    public String book(){
        return "form";
    }
    @GetMapping("/book/{bookId}")
    public String book(@PathVariable Integer bookId,Model model){
        Book book = bookService.queryBuId(bookId);
        model.addAttribute("book",book);
        return "form";
    }
    @DeleteMapping(value = "/book/{bookId}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String delete(@PathVariable Integer bookId){
        Boolean b = bookService.deleteBook(bookId);
        return "{\"success\":"+b+"}";
    }

    @PostMapping(value = "/book",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String add(Book book){
        Boolean b = bookService.addBook(book);
        return "{\"success\":"+b+"}";
    }

    @PutMapping(value = "/book",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(Book book){
        Boolean b = bookService.save(book);
        return "{\"success\":"+b+"}";
    }

}
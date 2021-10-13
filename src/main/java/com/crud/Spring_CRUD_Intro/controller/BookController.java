package com.crud.Spring_CRUD_Intro.controller;

import com.crud.Spring_CRUD_Intro.entity.Book;
import com.crud.Spring_CRUD_Intro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/bookservice/books")
    public List<Book> getAllBooks(){
        List<Book> allBooks  = bookService.getAllBooks();
        return allBooks;
    }
    @GetMapping("/bookservice/books/{id}")
    public Book getBookById(@PathVariable("id") int bookId){
        Book bookById  = bookService.getBookById(bookId);
        return bookById;
    }
    @PostMapping("/bookservice/books")
    public Book createNewBook(@RequestBody Book book){
        Book newBook = bookService.createNewBook(book);
        return newBook;
    }
    @DeleteMapping("/bookservice/books/{id}")
    public String deleteBook(@PathVariable("id") int bookId){
        String response = bookService.deleteBook(bookId);
        return  response;
    }
    @PutMapping("/bookservice/books")
    public Book updateBook(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        return updatedBook;
    }
}

package com.crud.Spring_CRUD_Intro.service;

import com.crud.Spring_CRUD_Intro.entity.Book;
import com.crud.Spring_CRUD_Intro.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public List<Book> getAllBooks(){
        List<Book> bookInfo = bookRepository.findAll();
        return bookInfo;
    }
    public Book getBookById(int bookId){
        Optional<Book> bookById = bookRepository.findById(bookId);
        if(bookById.isEmpty()){
            return new Book();
        }else{
            return bookById.get();
        }
    }
    public Book createNewBook(Book book){
        Book newBook = bookRepository.save(book);
        return newBook;
    }
    public String deleteBook(int bookid){
        Book deleteBook = bookRepository.findById(bookid).get();
        try{
            bookRepository.delete(deleteBook);
            return "Deleted Successfully";
        }catch (Exception exception){
            return "Delete failed";
        }
    }
    public Book updateBook(Book book){
        Optional<Book> updatedBook = bookRepository.findById(book.getBook_Id());
        if(updatedBook.isEmpty()){
            return new Book();
        }else{
            updatedBook.get().setName(book.getName());
            updatedBook.get().setAuthor(book.getAuthor());
            updatedBook.get().setPublication(book.getPublication());
            updatedBook.get().setCategory(book.getCategory());
            updatedBook.get().setCategory(book.getCategory());
            updatedBook.get().setPages(book.getPages());
            updatedBook.get().setPrice(book.getPrice());
            bookRepository.save(updatedBook.get());
            return updatedBook.get();
        }
    }
}

package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.book;
import com.bookstore.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository brepo;
    public void save(book b){
        brepo.save(b);
    }
    public List<book>getAllBook(){
        return brepo.findAll();
    }
    public book getBookById(int id){
        return brepo.findById(id).get();
    }
    public void deleteById(int id){
        brepo.deleteById(id);
    }
}

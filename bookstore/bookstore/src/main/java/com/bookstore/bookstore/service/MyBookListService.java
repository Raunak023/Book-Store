package com.bookstore.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.bookstore.repository.MyBookRepository;
import com.bookstore.bookstore.entity.MyBookList;

import java.util.List;

@Service
public class MyBookListService {
     @Autowired
    private  MyBookRepository myBookRepository;


    public void saveMyBooks(MyBookList book){
        myBookRepository.save(book);
    }
    public List<MyBookList>getAllMyBooks(){
        return myBookRepository.findAll();
    }
    public  void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}


package com.bookstore.bookstore.Controller;

import com.bookstore.bookstore.entity.MyBookList;
import com.bookstore.bookstore.entity.book;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.bookstore.bookstore.entity.book;


import java.util.*;

@Controller
public class BookController {
    @Autowired
    private BookService service;

   @Autowired
   private MyBookListService myBookService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookregister(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<book>list=service.getAllBook();
        ModelAndView m=new ModelAndView();
        m.setViewName("bookList");
        m.addObject("book",list);
        return new ModelAndView("bookList","book",list);

    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute book b){
        service.save(b);
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList>list= myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        book b=service.getBookById(id);
//        System.out.println("DEBUG: Book selected - ID: " + b.getId() + ", Name: " + b.getName() + ", Author: " + b.getAuthor() + ", Price: " + b.getPrice());
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id")int id, Model model){
      book b=  service.getBookById(id);
      model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }



}

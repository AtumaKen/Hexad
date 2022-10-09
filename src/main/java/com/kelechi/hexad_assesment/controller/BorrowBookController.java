package com.kelechi.hexad_assesment.controller;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BorrowBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowBookController {

    private final BorrowBookService service;

    @GetMapping("{id}")
    public List<Book> borrowBook(@PathVariable Long id){
       return service.borrow(id);
    }

    @GetMapping
    public List<Book> getBorrowedBooks(){
        return service.getBorrowedBooks();
    }
}

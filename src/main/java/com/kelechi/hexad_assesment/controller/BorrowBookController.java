package com.kelechi.hexad_assesment.controller;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BorrowBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000",  allowedHeaders = "OPTIONS")
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

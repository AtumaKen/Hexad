package com.kelechi.hexad_assesment.controller;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {


    private final BookService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll(){
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Book returnBorrowedBook(@RequestBody Book book){
        return null;
    }
}

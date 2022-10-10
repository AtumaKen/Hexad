package com.kelechi.hexad_assesment.controller;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000",  allowedHeaders = "OPTIONS")
@RestController
@RequestMapping("books")
@Slf4j
@RequiredArgsConstructor
public class BookController {


    private final BookService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll(){
        log.info("Get all");
        return service.getAll();
    }

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    public Book returnBorrowedBook(@RequestBody Book book){
        return service.returnBook(book);
    }
}

package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.models.Book;

import java.util.List;

public interface BorrowService {
    List<Book> borrow(Long i);
}

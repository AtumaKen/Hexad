package com.kelechi.hexad_assesment.controller;


import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BorrowBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ContextConfiguration(classes = {BorrowBookControllerTest.class, BorrowBookService.class})
@WebMvcTest
public class BorrowBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BorrowBookService borrowBookService;


    @Test
    void borrowBookControllerTest() throws Exception {
        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings");
        Book book2  = new Book(2L, "Animal Farm", "George Owel");

        List<Book> books = new ArrayList<>(List.of(book1, book2));


        books.remove(book1);
        when(borrowBookService.borrow(1L)).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/borrow/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());

    }
}

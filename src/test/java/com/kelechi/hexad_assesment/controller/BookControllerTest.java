package com.kelechi.hexad_assesment.controller;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import com.kelechi.hexad_assesment.services.BorrowBookService;
import com.kelechi.hexad_assesment.services.impl.BookServiceImpl;
import com.kelechi.hexad_assesment.services.impl.BorrowBookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
//@ContextConfiguration(classes = {BookControllerTest.class, BookService.class})
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private BorrowBookService borrowBookService;

    private List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Harry Potter", "JK Rowlings"));
        books.add(new Book(2L, "Animal Farm", "George Owel"));
        return books;
    }

    @Test
    void getAllBooks() throws Exception {
        List<Book> books = getBooks();
        when(bookService.findAll()).thenReturn(books);
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }



    @Test
    void returnEmptyListWhenLibraryIsEmpty() throws Exception {
        when(bookService.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0))).andDo(print());
    }


}

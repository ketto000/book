package com.cos.book.web;

//단위테스트: controller, Filter, ControllerAdvice

import com.cos.book.domain.Book;
import com.cos.book.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@WebMvcTest
//@ExtendWith({SpringExtension.class})
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;


    @Test
    public void save_test() throws JsonProcessingException {
        //give(테스트를 하기 위한 준비)

//        int i = 200;
//        Long l2 = new Long(i);
//        Book book = new Book(l2,"스프링따라하기","코스");
//        String content = new ObjectMapper().writeValueAsString(book);



    }

}

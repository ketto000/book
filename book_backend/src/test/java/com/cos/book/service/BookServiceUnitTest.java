package com.cos.book.service;


import com.cos.book.BookRepository.BookRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/*
단위 테스트 (Service와 관련된 애들만 메모리에 띄우면됨)
BoardRepository 


*/
@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTest {

    @InjectMocks //해당파일에 @Mock로 등록된 모든 애들을 주입받는다
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;


//    public BookServiceUnitTest(BookService bookService, BookRepository bookRepository) {
//        this.bookService = bookService;
//        this.bookRepository = bookRepository;
//    }
}

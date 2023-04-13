package com.cos.book.BookRepository;

import com.cos.book.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository 적어야 스프링 IOC에 빈으로 등록이 되는데
//JpaRepository를 Extends하면 생략 가능함
//JpaRepository는 CRUD 함수를 들고 있다
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContaining  (String searchKeyword, Pageable pageable);
}

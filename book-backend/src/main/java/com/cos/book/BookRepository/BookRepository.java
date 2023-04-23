package com.cos.book.BookRepository;

import com.cos.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository 적어야 스프링 IOC에 빈으로 등록이 되는데
//JpaRepository를 Extends하면 생략 가능함
//JpaRepository는 CRUD 함수를 들고 있다
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT a FROM Book a where a.title like %:titles% order by a.id DESC")
    List<Book> queryAnnotationTest1(@Param("titles") String searchWord); //전체필드시

    @Query("SELECT a.title FROM Book a where a.title like %:titles% order by a.id DESC")

//    @Options(useGeneratedKeys = true, keyProperty = "userIdx")
    List<Object> queryAnnotationTest2(@Param("titles") String searchWord); //일부 필드시


}

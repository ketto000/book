package com.cos.book.web;

import com.cos.book.domain.Book;
import com.cos.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


//security(라이브러리 적용)-CORS 정책을 가지고 있음
@RequiredArgsConstructor
@RestController
public class BookController {

  @Autowired
    private BookService bookService;

    @PostMapping("/api/book")
    public ResponseEntity<?>save(@RequestBody Book book){
                 return new ResponseEntity<>(bookService.저장하기(book),HttpStatus.CREATED);
    }

    @PostMapping("/api/book")
    public ResponseEntity<?>save(Book book, Model model, MultipartFile imgfile) throws Exception{
        bookService.write(book,imgfile) ;
        return new ResponseEntity<>("ok",HttpStatus.CREATED);
    }





    @GetMapping("/api/book/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.한건가져오기(id), HttpStatus.OK);
    }

    @GetMapping("/api/")
    public ResponseEntity<?>findAll() {
        return new ResponseEntity<>(bookService.모두가져오기(), HttpStatus.OK);
//        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

     @PutMapping("/api/book/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.수정하기(id,book),HttpStatus.OK);
    }

     @DeleteMapping("/api/book/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.삭제하기(id),HttpStatus.OK);
    }


}

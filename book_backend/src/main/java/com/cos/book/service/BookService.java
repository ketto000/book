package com.cos.book.service;

import com.cos.book.BookRepository.BookRepository;
import com.cos.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

//기능을 정의할 수 있고 ,트랜젝션 관리할 수 있음
@Transactional
@RequiredArgsConstructor
@Service
public class BookService {
 //함수 => 송금()-> 레파지토리에 여러개의  함수 실행-> commit or rollback;

    private final BookRepository bookRepository;

    @Transactional //서비스 함수가 종료될 때 commit할지 rollback할지 트랜잭션을 관리하겠다.
    public void write(Book book, MultipartFile file) throws Exception{

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
        //경로
        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + "img_" + file.getOriginalFilename();
        //랜덤파일이름 생성
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);
        book.setFilename(fileName);
        book.setFilepath("/files/" + fileName );

        bookRepository.save(book);
    }



    @Transactional(readOnly = true)
    public Book 한건가져오기(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("id를 확인해주세여"));
    }

    public List<Book>모두가져오기(){

        return bookRepository.findAll(Sort.by(Sort.Direction.DESC,"id")); //역정렬



    }

    public Book 수정하기(Long id, Book book){
        Book bookEntity = bookRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("id를 확인해주세요"));
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        return bookEntity;
    } //함수 종료->트렌잭션 종료=>영속화 되어있는 데이터를 DB로 갱신(flush)

    @Transactional
    public String 삭제하기(Long id){
        bookRepository.deleteById(id);
        return "ok";
    }

}

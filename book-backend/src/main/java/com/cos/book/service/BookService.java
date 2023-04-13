package com.cos.book.service;

import com.cos.book.BookRepository.BookRepository;
import com.cos.book.BookRepository.FilesRepository;
import com.cos.book.domain.Book;
import com.cos.book.domain.File_prc;
import com.cos.book.utill.CurrentDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

     private final FilesRepository filesRepository;

    public void fileupLoad(Book book,  List<MultipartFile> fileList) throws Exception{
        CurrentDateTime get_time= new CurrentDateTime();

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
        //경로

        UUID uuid = UUID.randomUUID();
        //랜덤파일이름 생성
        String make_key=uuid + "";

        for(MultipartFile file : fileList) {
            String fileName = uuid + "_" + "img_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, fileName);
            file.transferTo(saveFile);
            File_prc file_prc = new File_prc(make_key,book.getAuthor(),fileName,projectPath,"게시판",get_time.get_nowData());



//
//            file_prc.setFilekey(make_key);
//            file_prc.setFileuser(book.getAuthor());
//            file_prc.setFilename(fileName);
//            file_prc.setFilepath(projectPath);
//            file_prc.setFiletype("게시판");
//            file_prc.setFiledate(get_time.get_nowData());
            filesRepository.save(file_prc);
        }

        book.setFilekey(make_key);
        bookRepository.save(book);




//        book.setfilekeyFilename(fileName);
//        book.setFilepath("/files/" + fileName );
//        bookRepository.save(book);


    }


    @Transactional //서비스 함수가 종료될 때 commit할지 rollback할지 트랜잭션을 관리하겠다.
    public ResponseEntity<?>저장하기(Book book, List<MultipartFile> file ) throws Exception {

        fileupLoad(book,file);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }







    @Transactional(readOnly = true)
    public Book 한건가져오기(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("id를 확인해주세여"));
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

    public List<Book>모두가져오기(){
        return bookRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }


    public List<Book> 검색가져오기(String a) {
        return bookRepository.queryAnnotationTest1(a);
    }

    public List<Object> 검색가져오기2(String a) {
        return bookRepository.queryAnnotationTest2(a);
    }

}

package com.cos.book.web;

import java.util.List;
import java.util.Map;

import com.cos.book.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
@Slf4j
@CrossOrigin
@RestController
public class testfileController {


    /*
        for (let i = 0; i < files.length; i++) {
            formData.append('files', files[i]);
        }
        formData.append('key', new Blob([ JSON.stringify(book) ], {type : "application/json"}));
     */

    @PostMapping("/api/test/file")
    public ResponseEntity<?> insertMypageQna(
            @RequestPart(value = "key") Book param,
            @RequestPart(value = "files",required = false) List<MultipartFile> fileList) throws Exception {

        System.out.println("빡킹");
        System.out.println(param);

        log.trace("trace log={}", param);
        log.debug("debug log={}", param);
        log.info("info log={}", param);
        log.warn("warn log={}", param);
        log.error("error log={}", param);


        for (MultipartFile file : fileList) {
            System.out.println(file.getOriginalFilename() + ":" + file.getSize());
        }




        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}


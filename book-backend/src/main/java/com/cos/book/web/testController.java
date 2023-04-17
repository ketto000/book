package com.cos.book.web;

import com.cos.book.domain.portfolio;
import com.cos.book.service.BookService;
import com.cos.book.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class testController {

    @Autowired
    private BookService bookService;

    @Autowired
    private  TestService testService;


    @GetMapping("/test")
    public String main(Model model) {
        model.addAttribute("data", "hello rozy~!");
        return "index";
    }

    
    //테스트
    @ResponseBody
    @GetMapping("/test2")
    public ResponseEntity<?> query_test(Model model) {
        return new ResponseEntity<>(bookService.검색가져오기("드래곤볼"), HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping("/test3")
    public ResponseEntity<?> query_test2(Model model) {
        return new ResponseEntity<>(bookService.검색가져오기2("드래곤볼"), HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping("/test4")
    public List<portfolio> test() {
        return testService.getAllDataList();
    }
    
}


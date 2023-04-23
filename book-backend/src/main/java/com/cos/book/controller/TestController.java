package com.cos.book.controller;

import java.util.List;

import com.cos.book.domain.portfolio;
import com.cos.book.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/hello2")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/test10")
    public List<portfolio> test() {
        return testService.getAllDataList();
    }
}
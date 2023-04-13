package com.cos.book.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

//통합테스트(모든Bean들을 똑같이 IOC에 올리고 테스트 한다

//@AutoConfigureMockMvc MockMvc를 IOC에 등록해줌
//@Transcational
@Slf4j
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)//가상
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//진짜
public class BookControllerIntegreUnitTest {

//    @Autowired
//    private MockMvc mockMvc;

    @Test
    public void save_test(){
        log.info("save_테스트() 시작=============>");
    }
}

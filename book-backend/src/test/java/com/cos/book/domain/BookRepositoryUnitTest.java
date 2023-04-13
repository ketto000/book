package com.cos.book.domain;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

//
@Transactional
@AutoConfigureTestDatabase(replace = Replace.ANY)//ANY 가짜디비 , Replace.NONE 리얼 DB
@DataJpaTest //Repository들을 다 IOC에 등록해둠
public class BookRepositoryUnitTest {


}

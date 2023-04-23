package com.cos.book.service;


import com.cos.book.domain.portfolio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TestService {
    List<portfolio> getAllDataList();
}



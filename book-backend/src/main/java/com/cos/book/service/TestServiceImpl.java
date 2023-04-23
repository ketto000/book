package com.cos.book.service;



import com.cos.book.dao.TestMapper;
import com.cos.book.domain.portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

//    @Autowired(required = true)
    private TestMapper testMapper;

    @Override
    public List<portfolio> getAllDataList() {
        return testMapper.getAllDataList();
    }
}

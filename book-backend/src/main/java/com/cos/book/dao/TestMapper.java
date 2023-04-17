package com.cos.book.dao;

import com.cos.book.domain.portfolio;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    List<portfolio> getAllDataList();
}

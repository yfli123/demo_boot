package com.example.demo.mapper;

import com.example.demo.entity.MyUser2;
import org.springframework.stereotype.Repository;

@Repository
public interface User2Mapper {
    public MyUser2 selectById(String userId);
}

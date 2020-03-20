package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.MyUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<MyUser> {
    public MyUser findex(String userid);

}

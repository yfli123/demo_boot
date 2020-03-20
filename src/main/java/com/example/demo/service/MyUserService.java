package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.MyUser;
import com.example.demo.entity.MyUser2;

import java.util.List;

public interface MyUserService {

    public void addUser2(MyUser myUser);

    public void addUser(MyUser myUser);

    public Page<MyUser> findUsers(int currentPage, int pageSize);

    public MyUser findUser(String userId);

    public int updateUser(MyUser user);

    public MyUser findex(String userId);

    public MyUser2 searchMultiTables(String userId);
}
package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.MyUser;
import com.example.demo.entity.MyUser2;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.User2Mapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserServiceImpl implements MyUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void addUser(MyUser myUser) {
        userMapper.insert(myUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser2(MyUser myUser) {
        userMapper.insert(myUser);
        MyUser address = new MyUser();
        address.setUserId("99");
        addressMapper.insert(address);
    }

    @Override
    public Page<MyUser> findUsers(int currentPage,int pageSize) {
        Page<MyUser> page = new Page<>(currentPage,pageSize);
        userMapper.selectPage(page,new QueryWrapper<>());
        return page;
    }

    @Override
    @Cacheable(value = "user",key = "#userId")
    public MyUser findUser(String userId){
       return userMapper.selectById(userId);
    }


    @Override
    @CacheEvict(value = "user",key = "#myUser.userId")
    public int updateUser(MyUser myUser){
        return userMapper.updateById(myUser);
    }

    @Override
    public MyUser findex(String userId) {
        return userMapper.findex(userId);
    }


    @Override
    public MyUser2 searchMultiTables(String userId) {
        return user2Mapper.selectById(userId);
    }
}

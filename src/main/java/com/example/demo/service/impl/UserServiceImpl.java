package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.UserDto;
import com.example.demo.generator.entity.UserInfo;
import com.example.demo.generator.service.IUserInfoService;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    IUserInfoService userInfoService;

    /**
     * 获取所有的用户
     *
     * @return
     */
    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<UserInfo> userInfos = userInfoService.list();
        for(UserInfo userInfo : userInfos){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userInfo,userDto);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    /**
     * 获取分页用户
     *
     * @param current
     * @param pageSize
     * @return
     */
    @Override
    public Page<UserDto> getPageUsers(int current, int pageSize) {
        Page<UserDto> page1 = new Page<>(current,pageSize);
        Page<UserInfo> page = new Page<>(current,pageSize);
        List<UserDto> userDtoList = new ArrayList<>();
        userInfoService.page(page,new QueryWrapper<>());
        for(UserInfo userInfo : page.getRecords()){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userInfo,userDto);
            userDtoList.add(userDto);
        }
        page1.setRecords(userDtoList);
        page1.setCurrent(page.getCurrent());
        page1.setSize(page.getSize());
        page1.setTotal(page.getTotal());
        return page1;
    }

    /**
     * 添加用户
     *
     * @param userDto
     * @return
     */
    @Override
    public Boolean addUser(UserDto userDto) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userDto,userInfo);
        //密码加密保存
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userInfo.setPassWord(bCryptPasswordEncoder.encode(userDto.getPassWord()));

        return userInfoService.save(userInfo);
    }

    /**
     * 更新用户
     *
     * @param userDto
     * @return
     */
    @Override
    public Boolean updateUser(UserDto userDto) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userDto,userInfo);
        return userInfoService.updateById(userInfo);
    }

    /**
     * 获取单个用户
     *
     * @param userId
     * @return
     */
    @Override
    public UserDto getUser(String userId) {
        UserDto userDto = new UserDto();
        UserInfo userInfo = userInfoService.getById(userId);
        BeanUtils.copyProperties(userInfo,userDto);
        return userDto;
    }

    /**
     * 通过用户编号删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public Boolean removeUserById(String userId) {
        return userInfoService.removeById(userId);
    }

    /**
     * 通过对象删除用户
     *
     * @param userDto
     * @return
     */
    @Override
    public Boolean removeUserById(UserDto userDto) {
        return userInfoService.removeById(userDto.getUserId());
    }
}

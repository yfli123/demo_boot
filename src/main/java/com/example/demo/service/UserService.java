package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * 获取所有的用户
     * @return
     */
    public List<UserDto> getAllUsers();


    /**
     * 获取分页用户
     * @return
     */
    public Page<UserDto> getPageUsers(int current, int pageSize);


    /**
     * 添加用户
     * @return
     */
    public Boolean addUser(UserDto userDto);

    /**
     * 更新用户
     * @return
     */
    public Boolean updateUser(UserDto userDto);

    /**
     * 获取单个用户
     * @return
     */
    public UserDto getUser(String userId);

    /**
     * 通过用户编号删除用户
     * @return
     */
    public Boolean removeUserById(String userId);


    /**
     * 通过对象删除用户
     * @return
     */
    public Boolean removeUserById(UserDto userDto);


}

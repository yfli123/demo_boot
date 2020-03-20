package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dto.UserDto;
import com.example.demo.message.ServiceMessage;
import com.example.demo.service.UserService;
import com.example.demo.utils.MessageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用户")
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getpageusers")
    @ApiOperation(value = "获取分页用户" , notes = "获取分页用户", httpMethod = "GET")
    @Transactional
    public ServiceMessage<Page<UserDto>> getPageUsers(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize){
        try {
            Page<UserDto> userDtoPage = userService.getPageUsers(currentPage,pageSize);
            return ServiceMessage.success(userDtoPage,"sys0000");
        } catch (Exception e) {
            log.error("查询客户分页数据出错：",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ServiceMessage.fail("","",e);
        }
    }

    @PostMapping("/adduser")
    @ApiOperation(value = "新增用户" , notes = "新增用户" , httpMethod = "POST")
    @Transactional
    public ServiceMessage<String> addUser(@RequestBody UserDto userDto){
        try {
            userService.addUser(userDto);
            return ServiceMessage.success("01","");
        } catch (Exception e) {
            log.error("添加用户失败：",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ServiceMessage.fail("02","",e);
        }
    }

    @DeleteMapping("/deluser")
    @ApiOperation(value = "删除用户" , notes = "删除用户" , httpMethod = "DELETE")
    @Transactional
    public ServiceMessage<String> delUser(@RequestParam(value = "userId") String userId){
        try {
            userService.removeUserById(userId);
            return ServiceMessage.success("01","");
        } catch (Exception e) {
            log.error("删除用户失败：",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ServiceMessage.fail("02","",e);
        }
    }

    @GetMapping("/getuser")
    @ApiOperation(value = "获取用户" , notes = "获取用户" , httpMethod = "GET")
    public ServiceMessage<UserDto> getUser(@RequestParam(value = "userId") String userId){
        ServiceMessage<UserDto> serviceMessage = new ServiceMessage<>();
        try {
            UserDto userDto = userService.getUser(userId);
            return ServiceMessage.success(userDto,"");
        } catch (Exception e) {
            log.error("获取用户失败：",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ServiceMessage.fail(null,"",e);
        }
    }
}

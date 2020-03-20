package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.MyUser;
import com.example.demo.entity.MyUser2;
import com.example.demo.message.ServiceMessage;
import com.example.demo.service.MyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用户操作controller" , tags = {"1","2"})
public class MyUserController {

    @Autowired
    private MyUserService myUserService;


    @GetMapping("/api/users/getalluser")
    @ApiOperation(value="新增用户",notes = "新增一个用户",httpMethod = "GET",tags = {"3"})
    public ServiceMessage<MyUser> getUsers(){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            Page<MyUser> myUserList = myUserService.findUsers(1,100);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("查询成功");
            serviceMessage.setBody(myUserList);
        }catch (Exception e){
            serviceMessage.setCode("9999");
            serviceMessage.setMessage("查询失败");
        }
        return serviceMessage;

    }


    @PostMapping("/api/users")
    @ApiOperation(value="新增用户",notes = "新增一个用户",httpMethod = "POST")
    public ServiceMessage<MyUser> addUser(@RequestBody @ApiParam(name = "user对象",value = "user对象1",required = true) MyUser user){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            myUserService.addUser(user);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("保存成功");
            serviceMessage.setBody(user);
        }catch (Exception e){
            serviceMessage.setCode("9999");
            serviceMessage.setMessage("保存失败");
        }
        return serviceMessage;

    }


    @GetMapping("/api/users")
    @ApiOperation(value="用户分页查询",notes = "用户分页查询",httpMethod = "GET")
    public ServiceMessage<Page<MyUser>> findUsers(@RequestParam(value = "currentPage") int currentPage, @RequestParam(value = "pageSize") int pageSize){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            Page<MyUser> myUserList = myUserService.findUsers(currentPage,pageSize);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("查询成功");
            serviceMessage.setBody(myUserList);
        }catch (Exception e){
            serviceMessage.setCode("9999");
            serviceMessage.setMessage("查询失败");
        }
        return serviceMessage;

    }

    @GetMapping("/api2/users/find")
    @ApiOperation(value="复杂sql配置案例",notes = "复杂sql配置案例",httpMethod = "GET")
    public ServiceMessage<MyUser> findex(@RequestParam String userId){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            //myUserService.addUser2(user);
            MyUser user = myUserService.findex(userId);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("保存成功");
            serviceMessage.setBody(user);
        }catch (Exception e){
            serviceMessage.setCode("9999");
            serviceMessage.setMessage("保存失败");
        }
        return serviceMessage;

    }

    @PostMapping("/api2/users")
    @ApiOperation(value="新增用户（事务控制）",notes = "新增一个用户（事务控制）",httpMethod = "POST")
    public ServiceMessage<MyUser> addUser2(@RequestBody MyUser user){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            myUserService.addUser2(user);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("保存成功");
            serviceMessage.setBody(user);
        }catch (Exception e){
            serviceMessage.setCode("9999");
            serviceMessage.setMessage("保存失败");
        }
        return serviceMessage;

    }


    @GetMapping("/api2/users/{userId}")
    @ApiOperation(value="根据编号查询用户",notes = "查询一个用户",httpMethod = "GET")
    public ServiceMessage<MyUser> queryUser(@PathVariable String userId){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            MyUser myUser = myUserService.findUser(userId);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("查询成功");
            serviceMessage.setBody(myUser);
        }catch (Exception e){
            serviceMessage.setCode("9999");
            serviceMessage.setMessage("查询失败");
        }
        return serviceMessage;

    }


    @PutMapping("/api2/users")
    @ApiOperation(value="更新用户",notes = "更新用户",httpMethod = "PUT")
    public ServiceMessage<MyUser> updateUser(@RequestBody MyUser user){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            int i = myUserService.updateUser(user);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("更新成功");
            serviceMessage.setBody(user);
        }catch (Exception e){
            serviceMessage.setCode("9999");
            serviceMessage.setMessage("更新失败");
        }
        return serviceMessage;

    }



    @GetMapping("/api2/users/multi")
    @ApiOperation(value="查询多表关联数据",notes = "查询多表关联数据",httpMethod = "GET")
    public ServiceMessage<MyUser2> searchMultiTables(@RequestParam String userId){

        ServiceMessage serviceMessage = new ServiceMessage();
        try {
            MyUser2 myUser2 = myUserService.searchMultiTables(userId);
            serviceMessage.setCode("0000");
            serviceMessage.setMessage("更新成功");
            serviceMessage.setBody(myUser2);
        }catch (Exception e){

            serviceMessage.setCode("9999");
            serviceMessage.setMessage("更新失败");
            serviceMessage.setBody(e);
        }
        return serviceMessage;

    }
}

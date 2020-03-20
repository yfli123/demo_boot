package com.example.demo.controller;

import com.example.demo.dto.MenuDto;
import com.example.demo.message.ServiceMessage;
import com.example.demo.service.MenuSevice;
import com.example.demo.service.impl.MenuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    @Autowired
    MenuSevice menuService;

    @GetMapping("/getmenus")
    @Transactional
    @ApiOperation(value = "获取所有的菜单",notes = "获取所有的菜单",httpMethod = "GET")
    public ServiceMessage<List<MenuDto>> getAllMenus(@RequestParam("lang") String lang){
        try {
            List<MenuDto> menuDtos = menuService.getMenus(lang);
            return ServiceMessage.success(menuDtos,"sys0000");
        } catch (Exception e){
            log.error("获取菜单异常：", e);
            //事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ServiceMessage.fail(null,"",e);
        }

    }
}

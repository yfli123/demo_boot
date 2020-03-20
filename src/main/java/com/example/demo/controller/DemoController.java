package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.ModelTemplate;
import com.example.demo.message.ServiceMessage;
import com.example.demo.service.DemoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class DemoController {

    @Autowired
    DemoService service;

    @ApiOperation(value = "测试案例1", notes = "测试标准按id查询", httpMethod = "GET")
    @GetMapping("/demo/{id}")
    public ServiceMessage<ModelTemplate> demoget(@PathVariable int id) throws Exception {
        log.info("start get default");
        ModelTemplate template = service.getModelTemplate(id);
        return ServiceMessage.success(template,"sys0000");
    }

    @ApiOperation(value = "测试案例2", notes = "测试自定义查询", httpMethod = "GET")
    @GetMapping("/demo/cust/{id}")
    public ServiceMessage<ModelTemplate> custget(@PathVariable int id) throws Exception {
        log.info("start get cust");
        ModelTemplate template = service.custgetModelTemplate(id);
        return ServiceMessage.success(template,"sys0000");
    }

    @ApiOperation(value = "分页查询测试", notes = "测试分页查询", httpMethod = "GET")
    @GetMapping("/demo/find")
    public ServiceMessage<Page<ModelTemplate>> findMore(@RequestParam int pageNo, @RequestParam int pageSize) throws Exception {
        log.info("start find");
        Page<ModelTemplate> templates = service.findMore(pageNo,pageSize);
        return ServiceMessage.success(templates,"sys0000");
    }
}
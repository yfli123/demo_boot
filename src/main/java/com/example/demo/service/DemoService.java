package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.ModelTemplate;
import com.example.demo.mapper.ModelTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    ModelTemplateMapper mapper;

    public ModelTemplate getModelTemplate(int id){
        return mapper.selectById(id);
    }

    public ModelTemplate custgetModelTemplate(int id){
        return mapper.custget(id);
    }

    public Page<ModelTemplate> findMore(int pageNo, int pageSize){
        Page<ModelTemplate> page = new Page<>(pageNo,pageSize);
        List<ModelTemplate> records = mapper.findByPaging(page);
        page.setRecords(records);
        return page;
    }
}

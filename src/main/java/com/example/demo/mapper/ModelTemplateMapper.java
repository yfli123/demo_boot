package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.ModelTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelTemplateMapper extends BaseMapper<ModelTemplate> {
    ModelTemplate custget(int id);

    List<ModelTemplate> findByPaging(Page page);
}

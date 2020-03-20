package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("ai_model_templates")
public class ModelTemplate {

    @TableId("templateId")
    private int id;

    @TableField("templateTitle")
    private String title;

    @TableField("templateDesc")
    private String desc;

}

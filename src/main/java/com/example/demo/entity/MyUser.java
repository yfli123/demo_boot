package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("myuser")
@ApiModel(value = "user对象描述")
public class MyUser {

    @TableId("userid")
    private String userId;

    @TableField("username")
    private String userName;

    @TableField("age")
    @ApiModelProperty(value = "test",name = "test1")
    private int age;
}

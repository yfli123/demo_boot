package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
public class MyUser2 implements Serializable{
    private String userId ;

    private String userName ;

    private int age ;

    private List<Address> addressList;
}

package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable{
    private int addressId;

    private String addressName ;

    private String belongUserId ;
}

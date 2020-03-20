package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDto implements Serializable {

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certId;

    /**
     * 电话号码
     */
    private String phoneNo;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 创建时间
     */
    private LocalDateTime inputTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}

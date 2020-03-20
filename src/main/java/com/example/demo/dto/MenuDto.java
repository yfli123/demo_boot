package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class MenuDto implements Serializable {

    /**
     * 菜单编号
     */
    private String menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 路由地址
     */
    private String routeUrl;

    /**
     * 菜单层级
     */
    private String menuLevel;

    /**
     * 是否子节点
     */
    private String leafNode;

    /**
     * 子菜单
     */
    private List<MenuDto> subMenus = new ArrayList<>();
}


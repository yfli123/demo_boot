package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuDtoForTree {
    /**
     * 菜单编号
     */
    private String id;

    /**
     * 菜单名称
     */
    private String label;

    /**
     * 子菜单
     */
    private List<MenuDtoForTree> children = new ArrayList<>();
}

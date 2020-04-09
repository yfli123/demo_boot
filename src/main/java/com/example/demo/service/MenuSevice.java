package com.example.demo.service;

import com.example.demo.dto.MenuDto;
import com.example.demo.dto.MenuDtoForTree;

import java.util.List;

public interface MenuSevice {
    public List<MenuDto> getMenus(String lang);

    public List<MenuDtoForTree> getMenuTree(String lang);
}

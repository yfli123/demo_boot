package com.example.demo.service;

import com.example.demo.dto.MenuDto;

import java.util.List;

public interface MenuSevice {
    public List<MenuDto> getMenus(String lang);
}

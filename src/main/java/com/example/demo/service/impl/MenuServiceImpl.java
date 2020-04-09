package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.constant.SystemConstant;
import com.example.demo.dto.MenuDto;
import com.example.demo.dto.MenuDtoForTree;
import com.example.demo.generator.entity.MenuInfo;
import com.example.demo.generator.service.impl.MenuInfoServiceImpl;
import com.example.demo.service.MenuSevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuSevice {

    @Autowired
    MenuInfoServiceImpl menuInfoService;

    /**
     * 获取菜单数据
     * @return
     */
    @Override
    public List<MenuDto> getMenus(String lang) {
        List<MenuDto> menuDtos = new ArrayList<>();
        QueryWrapper<MenuInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("menu_id");
        List<MenuInfo> menuInfos = menuInfoService.list(queryWrapper);
        for(MenuInfo menuInfo : menuInfos){
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menuInfo,menuDto);
            if(SystemConstant.LANG_EN.equals(lang)){
                menuDto.setMenuName(menuInfo.getMenuEnName());
            }
            /*menuDto.setMenuId(menuInfo.getMenuId());
            menuDto.setMenuName(menuInfo.getMenuName());*/
            if(SystemConstant.MENU_LEVEL_1.equals(menuInfo.getMenuLevel())){//层级一
                menuDtos.add(menuDto);
            }else if(SystemConstant.MENU_LEVEL_2.equals(menuInfo.getMenuLevel())){//层级二
                menuDtos.get(menuDtos.size() - 1).getSubMenus().add(menuDto);
            }else if(SystemConstant.MENU_LEVEL_3.equals(menuInfo.getMenuLevel())){//层级三
                List<MenuDto> menuDtos1 = menuDtos.get(menuDtos.size() - 1).getSubMenus();
                menuDtos1.get(menuDtos1.size() - 1).getSubMenus().add(menuDto);
            }else if(SystemConstant.MENU_LEVEL_4.equals(menuInfo.getMenuLevel())){//层级四
                List<MenuDto> menuDtos1 = menuDtos.get(menuDtos.size() - 1).getSubMenus();
                List<MenuDto> menuDtos2 = menuDtos1.get(menuDtos1.size() - 1).getSubMenus();
                menuDtos2.get(menuDtos2.size() - 1).getSubMenus().add(menuDto);

            }
        }

        return menuDtos;
    }


    /**
     * 获取菜单数据
     * @return
     */
    @Override
    public List<MenuDtoForTree> getMenuTree(String lang) {
        List<MenuDtoForTree> menuDtoForTrees = new ArrayList<>();
        QueryWrapper<MenuInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("menu_id");
        List<MenuInfo> menuInfos = menuInfoService.list(queryWrapper);
        for(MenuInfo menuInfo : menuInfos){
            MenuDtoForTree menuDtoForTree = new MenuDtoForTree();
            // BeanUtils.copyProperties(menuInfo,menuDtoForTree);

            menuDtoForTree.setId(menuInfo.getMenuId());
            if(SystemConstant.LANG_EN.equals(lang)){
                menuDtoForTree.setLabel(menuInfo.getMenuEnName());
            } else {
                menuDtoForTree.setLabel(menuInfo.getMenuName());
            }
            /*menuDto.setMenuId(menuInfo.getMenuId());
            menuDto.setMenuName(menuInfo.getMenuName());*/
            if(SystemConstant.MENU_LEVEL_1.equals(menuInfo.getMenuLevel())){//层级一
                menuDtoForTrees.add(menuDtoForTree);
            }else if(SystemConstant.MENU_LEVEL_2.equals(menuInfo.getMenuLevel())){//层级二
                menuDtoForTrees.get(menuDtoForTrees.size() - 1).getChildren().add(menuDtoForTree);
            }else if(SystemConstant.MENU_LEVEL_3.equals(menuInfo.getMenuLevel())){//层级三
                List<MenuDtoForTree> menuDtoForTrees1 = menuDtoForTrees.get(menuDtoForTrees.size() - 1).getChildren();
                menuDtoForTrees1.get(menuDtoForTrees1.size() - 1).getChildren().add(menuDtoForTree);
            }else if(SystemConstant.MENU_LEVEL_4.equals(menuInfo.getMenuLevel())){//层级四
                List<MenuDtoForTree> menuDtoForTrees1 = menuDtoForTrees.get(menuDtoForTrees.size() - 1).getChildren();
                List<MenuDtoForTree> menuDtoForTrees2 = menuDtoForTrees1.get(menuDtoForTrees1.size() - 1).getChildren();
                menuDtoForTrees2.get(menuDtoForTrees2.size() - 1).getChildren().add(menuDtoForTree);

            }
        }

        return menuDtoForTrees;
    }
}

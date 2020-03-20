package com.example.demo.generator.service.impl;

import com.example.demo.generator.entity.MenuInfo;
import com.example.demo.generator.mapper.MenuInfoMapper;
import com.example.demo.generator.service.IMenuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author yfli
 * @since 2020-01-02
 */
@Service
public class MenuInfoServiceImpl extends ServiceImpl<MenuInfoMapper, MenuInfo> implements IMenuInfoService {

}

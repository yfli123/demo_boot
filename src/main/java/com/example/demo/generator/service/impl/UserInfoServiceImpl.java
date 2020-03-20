package com.example.demo.generator.service.impl;

import com.example.demo.generator.entity.UserInfo;
import com.example.demo.generator.mapper.UserInfoMapper;
import com.example.demo.generator.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author yfli
 * @since 2020-01-01
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}

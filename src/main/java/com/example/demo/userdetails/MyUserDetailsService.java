package com.example.demo.userdetails;

import com.example.demo.generator.entity.UserInfo;
import com.example.demo.generator.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserInfoServiceImpl userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoService.getById(username);
        String userId = userInfo.getUserId();
        String passwd = userInfo.getPassWord();
        boolean enabled = true;
        boolean accountNonLocked = true;
        //检查凭证是否没有过期
        boolean credentialsNonExpired = true;
        boolean accountNonExpired = true;
        return new User(username, passwd, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, new ArrayList<>());
    }
}

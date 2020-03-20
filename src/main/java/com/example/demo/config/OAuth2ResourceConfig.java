package com.example.demo.config;

import com.example.demo.oauth2.CustomAuthenticationEntryPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Slf4j
@Configuration
@EnableResourceServer
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint ;

//    @Bean
//    public CustomLogoutSuccessHandler customLogoutSuccessHandler(){
//        return new CustomLogoutSuccessHandler();
//    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)              
            .and().requestMatchers().antMatchers("/**")
            .and().authorizeRequests().antMatchers("/**").authenticated();
    }
}
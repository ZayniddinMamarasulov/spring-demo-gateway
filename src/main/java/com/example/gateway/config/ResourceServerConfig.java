package com.example.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/oauth/**").permitAll()
                .antMatchers("/**").authenticated();
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login();

    }

//    @Bean
//    @LoadBalanced
//    OAuth2RestTemplate oAuth2RestTemplate(UserInfoRestTemplateFactory userInfoRestTemplateFactory){
//        return userInfoRestTemplateFactory.getUserInfoRestTemplate();
//    }
}

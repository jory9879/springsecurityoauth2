package com.jory.springsecurityoauth2demo4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter{
    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //配置clientｉｄ　
                .withClient("admin")
                //配置client-secret
                .secret(passwordEncoder.encode("112233"))
                .accessTokenValiditySeconds(3600)
                .redirectUris("http://www.baidu.com")
                //配置申请的范围
                .scopes("all")
                .authorizedGrantTypes("authorization_code");
    }
}

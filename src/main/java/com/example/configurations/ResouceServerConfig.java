package com.example.configurations;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configurable
@EnableResourceServer
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public void config(HttpSecurity http) throws Exception {
        super.configure(http);
    }

}

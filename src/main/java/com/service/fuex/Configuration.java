package com.service.fuex;

import org.springframework.web.servlet.config.annotation.*;

@org.springframework.context.annotation.Configuration
@EnableWebMvc
public class Configuration extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").maxAge(3600);
    }
}

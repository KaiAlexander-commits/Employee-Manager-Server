package com.chambers.employeemgrserver.domain.employee.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/employees/**")
                .allowedOrigins("http://localhost:5174", "http://localhost:4000")  // Frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE");  // Allowed HTTP methods
    }
}

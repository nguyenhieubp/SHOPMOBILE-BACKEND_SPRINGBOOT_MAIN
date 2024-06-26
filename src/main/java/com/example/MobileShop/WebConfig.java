package com.example.MobileShop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Cho phép tất cả các origin (domain) gửi yêu cầu tới
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE") // Cho phép các phương thức GET, POST, PUT, PATCH, DELETE
                .allowedHeaders("*"); // Cho phép tất cả các header đi kèm
    }
}

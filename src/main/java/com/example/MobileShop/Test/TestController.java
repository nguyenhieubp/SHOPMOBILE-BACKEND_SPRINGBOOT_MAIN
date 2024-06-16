package com.example.MobileShop.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/test")
public class TestController {
    @GetMapping()
    public String HelloWorld(){
        return "hello world";
    }
}

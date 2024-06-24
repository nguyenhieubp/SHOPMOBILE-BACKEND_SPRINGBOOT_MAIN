package com.example.MobileShop.Test;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/test")
public class TestController {
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public String HelloWorld(){
        return "hello world";
    }
}

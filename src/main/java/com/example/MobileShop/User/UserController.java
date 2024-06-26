package com.example.MobileShop.User;

import com.example.MobileShop.Config.FormatResponse.ApiResponse;
import com.example.MobileShop.Config.Jwt.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUser(){
        ApiResponse<List<User>> response = new ApiResponse<>(HttpStatus.OK.value(), "success", userService.getAllUser());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> authenticate(@PathVariable UUID id) {
        ApiResponse<User> response = new ApiResponse<>(HttpStatus.OK.value(),"success", userService.getUserById(id));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable UUID id,@Valid @RequestBody UserDto userUpdate){
        ApiResponse<User> response = new ApiResponse<>(HttpStatus.OK.value(), "success",userService.updateUser(id,userUpdate));
        return ResponseEntity.ok().body(response);
    }

}

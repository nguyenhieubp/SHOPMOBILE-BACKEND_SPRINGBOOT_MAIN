package com.example.MobileShop.User;

import com.example.MobileShop.Roles.RoleDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> OK() {
//        return ResponseEntity.ok().body(userService.createUser(roles));
        return ResponseEntity.ok().body("OK");
    }


    @PostMapping("/register")
    public ResponseEntity<?> createRoles(@Valid @RequestBody UserDto userDto ) {
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }

}

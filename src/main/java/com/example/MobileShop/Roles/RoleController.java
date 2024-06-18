package com.example.MobileShop.Roles;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoles(@Valid @RequestBody RoleDto roles ) {
        return ResponseEntity.ok().body(roleService.createRole(roles));
    }


    @GetMapping("/getAllRoles")
    public List<Roles> getAllRoles(){
        return roleService.getAllRoles();
    }
}

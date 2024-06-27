package com.example.MobileShop.UserRoles;

import com.example.MobileShop.Config.FormatResponse.ApiResponse;
import com.example.MobileShop.Roles.Roles;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;


    @PostMapping("/add-role-user")
    public ResponseEntity<?> updateRoleUser(@RequestBody UserRoleDto userRoles){
        return ResponseEntity.ok().body(userRoleService.updateRoleForUser(userRoles));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoleUser(@PathVariable UUID id,@RequestBody RoleCode roleCode){
        boolean isDelete = userRoleService.deleteRoleForUser(id,roleCode);
        ApiResponse<Boolean> response = new ApiResponse<>(HttpStatus.OK.value(), "success",isDelete);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRoleUser(){
        ApiResponse<List<UserRoles>> response = new ApiResponse<>(HttpStatus.OK.value(), "success", userRoleService.getAllRoleUser());
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<List<Roles>> getAllRoleUserByUserId(@PathVariable UUID id) {
        List<Roles> roles = userRoleService.getAllRoleUserByUserId(id);
        return ResponseEntity.ok(roles);
    }

}

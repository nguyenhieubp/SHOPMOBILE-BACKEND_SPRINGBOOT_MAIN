package com.example.MobileShop.UserRoles;

import com.example.MobileShop.Exception.ResourceNotFoundException;
import com.example.MobileShop.Roles.RoleRepository;
import com.example.MobileShop.Roles.Roles;
import com.example.MobileShop.User.User;
import com.example.MobileShop.User.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserRoles updateRoleForUser(UserRoleDto userRoleInput){
        UserRoles userRole = modelMapper.map(userRoleInput, UserRoles.class);

        // Lấy đối tượng User từ database
        User user = userRepository.findById(userRoleInput.getUser())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userRoleInput.getUser()));
        userRole.setUser(user);

        // Lấy đối tượng Role từ database
        Roles role = roleRepository.findById(userRoleInput.getRole())
                .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + userRoleInput.getRole()));
        userRole.setRole(role);

        return userRoleRepository.save(userRole);
    }

    public boolean deleteRoleForUser(UUID id){
        UserRoles userRoles = userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole not found with id " + id));
        userRoleRepository.delete(userRoles);
        return true;
    }

    public List<UserRoles> getAllRoleUser(){
       return userRoleRepository.findAll();
    }

    public List<Roles> getAllRoleUserByUserId(UUID id) {
        return userRoleRepository.findRolesByUserId(id);
    }
}

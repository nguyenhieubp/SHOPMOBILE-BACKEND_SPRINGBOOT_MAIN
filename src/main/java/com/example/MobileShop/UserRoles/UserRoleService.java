package com.example.MobileShop.UserRoles;

import com.example.MobileShop.Exception.ResourceNotFoundException;
import com.example.MobileShop.Roles.RoleRepository;
import com.example.MobileShop.Roles.Roles;
import com.example.MobileShop.User.User;
import com.example.MobileShop.User.UserRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public boolean deleteRoleForUser(UUID userId, RoleCode roleCode) {
        System.out.println("ROLE "+roleCode.getRoleCode());
        int deletedCount = userRoleRepository.deleteRoleUser(userId, roleCode.getRoleCode());
        return deletedCount > 0;
    }

    public List<UserRoles> getAllRoleUser(){
       return userRoleRepository.findAll();
    }

    public List<Roles> getAllRoleUserByUserId(UUID id) {
        return userRoleRepository.findRolesByUserId(id);
    }
}

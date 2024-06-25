package com.example.MobileShop.Roles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private ModelMapper modelMapper;

    public Roles createRole(RoleDto roleDto) {
        System.out.println(roleDto.toString());
        Roles roles = modelMapper.map(roleDto, Roles.class);
        return roleRepository.save(roles);
    }

    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }
}

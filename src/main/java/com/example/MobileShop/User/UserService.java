package com.example.MobileShop.User;

import com.example.MobileShop.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    public Page<User> searchUsers(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findByUserNameOrEmailContaining(keyword, pageable);
    }

    public User getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return null;
    }

    public User updateUser(UUID id,UserDto useUpdate) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        User userUpdate = modelMapper.map(useUpdate, User.class);
        userRepository.save(userUpdate);
        return userUpdate;
    }
}

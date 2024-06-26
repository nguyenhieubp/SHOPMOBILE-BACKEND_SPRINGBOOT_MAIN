package com.example.MobileShop.User.Auth;

import com.example.MobileShop.Config.Jwt.JwtService;
import com.example.MobileShop.User.User;
import com.example.MobileShop.User.UserDto;
import com.example.MobileShop.User.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public boolean createUser(UserDto userDto) {
        System.out.println(userDto);
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return true;
    }


    public LoginResponse login(LoginUserDto userLogin) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogin.getEmail(),
                        userLogin.getPassword()
                )
        );

        User user = userRepository.findByEmail(userLogin.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        user.setRefresh_token(refreshToken);
        userRepository.save(user);

        return new LoginResponse()
                .setToken(accessToken)
                .setExpiresIn(jwtService.getExpirationTime())
                .setUser(user);
    }

    public Optional<LoginResponse> refreshAccessToken(String refreshToken) {
        if (jwtService.isRefreshTokenValid(refreshToken)) {
            String username = jwtService.extractUsername(refreshToken);
            System.out.println("Name "+username);
            User user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new RuntimeException("User not found!"));

            String newAccessToken = jwtService.generateToken(user);
            return Optional.of(new LoginResponse()
                    .setToken(newAccessToken)
                    .setExpiresIn(jwtService.getExpirationTime())
                    .setUser(user));
        }
        return Optional.empty();
    }

}

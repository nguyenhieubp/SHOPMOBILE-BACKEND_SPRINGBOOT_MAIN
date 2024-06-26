package com.example.MobileShop.User.Auth;

import com.example.MobileShop.Config.Jwt.JwtService;
import com.example.MobileShop.User.ResponseUser;
import com.example.MobileShop.User.User;
import com.example.MobileShop.User.UserDto;
import com.example.MobileShop.User.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping("/register")
    public ResponseEntity<?> createRoles(@Valid @RequestBody UserDto userDto ) {
        return ResponseEntity.ok().body(authService.createUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginUserDto loginUserDto) {
        LoginResponse loginResponse = authService.login(loginUserDto);
        return ResponseEntity.ok(loginResponse);
    }


    @GetMapping("/me")
    public ResponseEntity<?> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        ResponseUser userDTO = new ResponseUser(currentUser);
        return ResponseEntity.ok(userDTO);
    }


    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshAccessToken(@RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        System.out.println("TOKEN "+requestRefreshToken);
        return authService.refreshAccessToken(requestRefreshToken)
                .map(tokenResponse -> ResponseEntity.ok().body(tokenResponse))
                .orElseThrow(() -> new RuntimeException("Refresh token is not valid!"));
    }
}

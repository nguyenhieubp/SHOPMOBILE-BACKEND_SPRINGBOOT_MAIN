package com.example.MobileShop.User.Auth;

import com.example.MobileShop.User.User;

public class LoginResponse {
    private String token;
    private long expiresIn;
    private User user;

    // Getters và Setters
    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LoginResponse setUser(User user) {
        this.user = user;
        return this;
    }
}

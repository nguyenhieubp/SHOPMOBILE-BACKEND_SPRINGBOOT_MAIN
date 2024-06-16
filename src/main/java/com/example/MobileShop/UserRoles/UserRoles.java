package com.example.MobileShop.UserRoles;
import com.example.MobileShop.Roles.Roles;
import com.example.MobileShop.User.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    private Date created_at;
    private Date updated_at;

    // Getters and setters
    public UUID getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UUID userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}


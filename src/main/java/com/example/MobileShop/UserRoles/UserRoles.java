package com.example.MobileShop.UserRoles;

import com.example.MobileShop.Roles.Roles;
import com.example.MobileShop.User.User;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "UserRoles")
@Entity
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userRoleId;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Roles role;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
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


    @Override
    public String toString() {
        return "UserRoles{" +
                "userRoleId=" + userRoleId +
                ", user=" + user +
                ", role=" + role +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}


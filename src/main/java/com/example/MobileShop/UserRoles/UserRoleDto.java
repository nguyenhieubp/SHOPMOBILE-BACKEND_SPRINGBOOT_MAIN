package com.example.MobileShop.UserRoles;

import java.util.Date;
import java.util.UUID;

public class UserRoleDto {
    private UUID userRoleId;

    private UUID user;

    private UUID role;

    private Date created_at = new Date();

    private Date updated_at = new Date();

    public UUID getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UUID userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public UUID getRole() {
        return role;
    }

    public void setRole(UUID role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "userRoleId=" + userRoleId +
                ", user=" + user +
                ", role=" + role +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

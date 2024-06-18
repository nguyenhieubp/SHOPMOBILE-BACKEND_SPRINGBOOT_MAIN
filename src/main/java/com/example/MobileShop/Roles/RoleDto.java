package com.example.MobileShop.Roles;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

public class RoleDto {
    @Valid

    private UUID roleId;

    @NotEmpty(message ="Thiếu role name")
    private String nameRole;

    @NotEmpty(message ="Thiếu role code")
    private String roleCode;

    private Date created_at;

    private Date updated_at;

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public @NotEmpty(message = "Thiếu role name") String getNameRole() {
        return nameRole;
    }

    public void setNameRole(@NotEmpty(message = "Thiếu role name") String nameRole) {
        this.nameRole = nameRole;
    }

    public @NotEmpty(message = "Thiếu role code") String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(@NotEmpty(message = "Thiếu role code") String roleCode) {
        this.roleCode = roleCode;
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

    public RoleDto() {
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "roleId=" + roleId +
                ", nameRole='" + nameRole + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

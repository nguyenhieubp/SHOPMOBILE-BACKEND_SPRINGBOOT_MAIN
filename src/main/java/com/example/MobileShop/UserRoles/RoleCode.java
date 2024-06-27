package com.example.MobileShop.UserRoles;

public class RoleCode {
    private String roleCode;

    public RoleCode() {}

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public RoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "RoleCode{" +
                "roleCode='" + roleCode + '\'' +
                '}';
    }
}

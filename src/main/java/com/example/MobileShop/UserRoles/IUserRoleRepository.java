package com.example.MobileShop.UserRoles;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IUserRoleRepository  extends JpaRepository<UserRoles, UUID> {
}

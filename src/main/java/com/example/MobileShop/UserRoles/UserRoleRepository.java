package com.example.MobileShop.UserRoles;

import com.example.MobileShop.Roles.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRoles, UUID> {
    @Query("SELECT ur.role FROM UserRoles ur WHERE ur.user.id = :userId")
    List<Roles> findRolesByUserId(@Param("userId") UUID userId);
}

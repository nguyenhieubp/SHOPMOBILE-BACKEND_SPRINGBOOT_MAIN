package com.example.MobileShop.UserRoles;

import com.example.MobileShop.Roles.Roles;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRoles, UUID> {
    @Modifying
    @Transactional
    @Query("DELETE FROM UserRoles ur WHERE ur.user.userId = :userId AND ur.role.roleCode = :roleCode")
    int deleteRoleUser(@Param("userId") UUID userId, @Param("roleCode") String roleCode);

    @Query("SELECT ur.role FROM UserRoles ur WHERE ur.user.userId = :userId")
    List<Roles> findRolesByUserId(@Param("userId") UUID userId);
}

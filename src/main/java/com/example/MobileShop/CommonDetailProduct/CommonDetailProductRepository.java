package com.example.MobileShop.CommonDetailProduct;

import com.example.MobileShop.Roles.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommonDetailProductRepository extends JpaRepository<CommonDetailProduct, UUID> {
    @Modifying
    @Query("DELETE FROM CommonDetailProduct WHERE code = :code")
    int deleteCommonDetail(@Param("code") double code);
}

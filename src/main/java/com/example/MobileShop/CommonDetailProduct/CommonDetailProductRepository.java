package com.example.MobileShop.CommonDetailProduct;

import com.example.MobileShop.Roles.Roles;
import org.springframework.data.domain.Sort;
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

    @Query("SELECT p FROM CommonDetailProduct p WHERE " +
            "(:category IS NULL OR p.category.name LIKE %:category%) AND " +
            "(:type IS NULL OR p.type.tag = :type) ")
    List<CommonDetailProduct> searchProducts(
            Sort sort,
            @Param("category") String category,
            @Param("type") String type);

}

package com.example.MobileShop.ProductSub;

import com.example.MobileShop.ProductSub.Request.ProductSubDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductSubRepository extends JpaRepository<ProductSub, UUID> {

    @Query("SELECT ps FROM ProductSub ps INNER JOIN ps.commonDetailProduct dt WHERE dt.commonProductId = :id")
    List<ProductSub> getAllProductSubByDetailProduct(@Param("id") UUID id);
}

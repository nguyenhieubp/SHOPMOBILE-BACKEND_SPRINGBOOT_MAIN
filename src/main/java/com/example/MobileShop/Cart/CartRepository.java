package com.example.MobileShop.Cart;

import com.example.MobileShop.Categories.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    @Query("SELECT c FROM Cart c WHERE c.user = :id")
    List<Cart> findCartByUseId(@Param("id") UUID id);

}


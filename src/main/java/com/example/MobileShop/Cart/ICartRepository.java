package com.example.MobileShop.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ICartRepository extends JpaRepository<Cart, UUID> {
}


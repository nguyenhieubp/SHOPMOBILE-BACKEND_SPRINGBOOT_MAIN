package com.example.MobileShop.ProductSub;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IProductSubRepository  extends JpaRepository<ProductSub, UUID> {
}

package com.example.MobileShop.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IProductTypeRepository extends JpaRepository<ProductType, UUID> {
}

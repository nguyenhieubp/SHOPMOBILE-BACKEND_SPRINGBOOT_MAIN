package com.example.MobileShop.CommonDetailProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ICommonDetailProductRepository extends JpaRepository<CommonDetailProduct, UUID> {
}

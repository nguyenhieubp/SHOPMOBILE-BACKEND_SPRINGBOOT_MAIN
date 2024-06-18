package com.example.MobileShop.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
}

package com.example.MobileShop.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IAddressRepository extends JpaRepository<Address, UUID> {
}


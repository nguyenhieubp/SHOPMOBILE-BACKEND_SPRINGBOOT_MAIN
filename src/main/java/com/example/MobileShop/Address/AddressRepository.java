package com.example.MobileShop.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    @Query("SELECT ad FROM Address ad WHERE ad.user = :userId ")
    List<Address> findAddressByUserId(@Param("userId") UUID userId);
}


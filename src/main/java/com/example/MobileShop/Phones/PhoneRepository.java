package com.example.MobileShop.Phones;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PhoneRepository extends JpaRepository<Phones, UUID> {

    @Query(value = "SELECT p FROM Phones p JOIN p.commonDetailProduct c " +
            "WHERE (:title IS NULL OR c.title LIKE %:title%) ")
    Page<Phones> findAllPhones(@Param("title") String title, Pageable pageable);


    @Transactional
    @Modifying
    @Query("DELETE FROM Phones p WHERE p.phoneId = :phoneId")
    int deleteByPhoneId(@Param("phoneId") UUID phoneId);
}

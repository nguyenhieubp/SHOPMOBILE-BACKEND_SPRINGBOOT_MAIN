package com.example.MobileShop.Phones;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IPhoneRepository extends JpaRepository<Phones, UUID> {
}

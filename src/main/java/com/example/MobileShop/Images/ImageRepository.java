package com.example.MobileShop.Images;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<Images, UUID> {
}

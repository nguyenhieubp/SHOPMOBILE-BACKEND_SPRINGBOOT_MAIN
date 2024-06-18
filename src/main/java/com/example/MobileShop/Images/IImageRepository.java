package com.example.MobileShop.Images;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IImageRepository extends JpaRepository<Images, UUID> {
}

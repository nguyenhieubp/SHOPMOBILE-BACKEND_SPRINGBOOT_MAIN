package com.example.MobileShop.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ICategoriesRepository extends JpaRepository<Categories, UUID> {
}

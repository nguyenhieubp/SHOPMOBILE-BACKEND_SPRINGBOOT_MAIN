package com.example.MobileShop.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CategoriesRepository extends JpaRepository<Categories, UUID> {
    @Query("SELECT c FROM Categories c WHERE c.parent_id = :parentId")
    List<Categories> findCategoryByParentId(@Param("parentId") UUID parentId);


    @Query("SELECT c FROM Categories c WHERE c.parent_id is NULL")
    List<Categories> getAllCategoryParent();

    @Query("SELECT c FROM Categories c WHERE c.name = :q")
    Categories getAllCategoryByName(@Param("q") String name);

}

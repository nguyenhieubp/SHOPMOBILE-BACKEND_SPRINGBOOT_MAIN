package com.example.MobileShop.Categories;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.UUID;

public class CategoryDto {
    @Valid
    private UUID categoryId;

    @NotEmpty(message = "Bắt buộc phải có name category")
    private String name;

    private UUID parent_id;

    private Date created_at = new Date();

    private Date updated_at = new Date();

    public @Valid UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@Valid UUID categoryId) {
        this.categoryId = categoryId;
    }

    public @NotEmpty(message = "Bắt buộc phải có name category") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Bắt buộc phải có name category") String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public UUID getParent_id() {
        return parent_id;
    }

    public void setParent_id(UUID parent_id) {
        this.parent_id = parent_id;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}

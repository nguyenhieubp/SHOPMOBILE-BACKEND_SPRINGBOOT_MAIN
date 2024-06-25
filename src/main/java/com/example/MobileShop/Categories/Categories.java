package com.example.MobileShop.Categories;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Table(name = "Categories")
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private UUID parent_id;

    @Column(name = "created_at")
    private Date created_at = new Date();

    @Column(name = "updated_at")
    private Date updated_at = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<CommonDetailProduct> products;

    // Getters and setters
    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getParent_id() {
        return parent_id;
    }

    public void setParent_id(UUID parent_id) {
        this.parent_id = parent_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Set<CommonDetailProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<CommonDetailProduct> products) {
        this.products = products;
    }
}

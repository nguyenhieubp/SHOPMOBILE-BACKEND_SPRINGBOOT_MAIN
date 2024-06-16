package com.example.MobileShop.ProductType;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID productTypeId;

    private String tag;
    private Date created_at;
    private Date updated_at;

    @OneToMany(mappedBy = "type")
    private Set<CommonDetailProduct> products;

    // Getters and setters
    public UUID getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(UUID productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

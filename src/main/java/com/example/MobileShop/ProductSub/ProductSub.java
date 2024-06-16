package com.example.MobileShop.ProductSub;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class ProductSub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID productSubId;

    private String key;
    private String value;
    private Date created_at;
    private Date updated_at;

    @OneToMany(mappedBy = "sub")
    private Set<CommonDetailProduct> products;

    // Getters and setters
    public UUID getProductSubId() {
        return productSubId;
    }

    public void setProductSubId(UUID productSubId) {
        this.productSubId = productSubId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

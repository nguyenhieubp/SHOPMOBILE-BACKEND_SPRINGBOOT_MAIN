package com.example.MobileShop.ProductSub;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Table(name = "ProductSub")
@Entity
public class ProductSub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productSubId;

    @Column(name = "product_key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "created_at")
    private Date created_at = new Date();

    @Column(name = "updated_at")
    private Date updated_at = new Date();


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "common_detail_product_id")
    private CommonDetailProduct commonDetailProduct;

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

    public CommonDetailProduct getCommonDetailProduct() {
        return commonDetailProduct;
    }

    public void setCommonDetailProduct(CommonDetailProduct commonDetailProduct) {
        this.commonDetailProduct = commonDetailProduct;
    }

    @Override
    public String toString() {
        return "ProductSub{" +
                "productSubId=" + productSubId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", commonDetailProduct=" + commonDetailProduct +
                '}';
    }
}

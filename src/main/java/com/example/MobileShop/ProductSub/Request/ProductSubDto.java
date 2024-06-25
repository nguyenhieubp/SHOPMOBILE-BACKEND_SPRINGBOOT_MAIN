package com.example.MobileShop.ProductSub.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public class ProductSubDto {
    @Valid

    private UUID productSubId;

    @NotEmpty(message = "Bắt buộc phải có key")
    private String key;

    @NotEmpty(message = "Bắt buộc phải có value")
    private String value;

    private Date created_at = new Date();

    private Date updated_at = new Date();

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

    @Override
    public String toString() {
        return "ProductSubDto{" +
                "productSubId=" + productSubId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

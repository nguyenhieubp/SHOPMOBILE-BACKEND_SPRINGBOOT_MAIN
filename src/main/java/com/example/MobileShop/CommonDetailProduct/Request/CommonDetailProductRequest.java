package com.example.MobileShop.CommonDetailProduct.Request;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.UUID;

public class CommonDetailProductRequest {
    private UUID commonProductId;

    private String title;

    private float price;

    private String description;

    private int quantity_of_goods;

    private int warranty;

    private double code = Math.random();

    private Date created_at = new Date();

    private Date updated_at = new Date();

    private UUID imageId;

    private UUID categoryId;

    private UUID productTypeId;

    public UUID getCommonProductId() {
        return commonProductId;
    }

    public void setCommonProductId(UUID commonProductId) {
        this.commonProductId = commonProductId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity_of_goods() {
        return quantity_of_goods;
    }

    public void setQuantity_of_goods(int quantity_of_goods) {
        this.quantity_of_goods = quantity_of_goods;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
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

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(UUID productTypeId) {
        this.productTypeId = productTypeId;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CommonDetailProductRequest{" +
                "commonProductId=" + commonProductId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity_of_goods=" + quantity_of_goods +
                ", warranty=" + warranty +
                ", code=" + code +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", imageId=" + imageId +
                ", categoryId=" + categoryId +
                ", productTypeId=" + productTypeId +
                '}';
    }
}

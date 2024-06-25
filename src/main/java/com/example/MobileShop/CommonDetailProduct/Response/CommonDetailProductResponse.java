package com.example.MobileShop.CommonDetailProduct.Response;

import com.example.MobileShop.Categories.Categories;
import com.example.MobileShop.Images.Images;
import com.example.MobileShop.ProductSub.ProductSub;
import com.example.MobileShop.ProductType.ProductType;
import jakarta.persistence.Column;

import java.util.Date;
import java.util.UUID;

public class CommonDetailProductResponse {
    private UUID commonProductId;

    private String title;

    private float price;

    private String description;

    private int quantity_of_goods;

    private int warranty;

    private Date created_at = new Date();

    private Date updated_at = new Date();

    private double code = Math.random();

    private Images images;

    private Categories category;

    private ProductType type;

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

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CommonDetailProductResponse{" +
                "commonProductId=" + commonProductId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity_of_goods=" + quantity_of_goods +
                ", warranty=" + warranty +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", code=" + code +
                ", images=" + images +
                ", category=" + category +
                ", type=" + type +
                '}';
    }
}

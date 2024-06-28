package com.example.MobileShop.CommonDetailProduct;

import com.example.MobileShop.Categories.CategoryDto;
import com.example.MobileShop.Images.ImagesDTO;
import com.example.MobileShop.ProductSub.Request.ProductSubDto;
import com.example.MobileShop.ProductType.ProductTypeDTO;
import com.example.MobileShop.Review.Review;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CommonDetailProductDTO {
    private UUID commonProductId;
    private String title;
    private float price;
    private String description;
    private int quantity_of_goods;
    private int warranty;
    private double code;
    private Date created_at;
    private Date updated_at;
    private List<Review> reviews;
    private ImagesDTO images;
    private CategoryDto category;
    private ProductTypeDTO type;
    private List<ProductSubDto> subs;
    private String desc;

    // Getters and setters

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

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }


    public ImagesDTO getImages() {
        return images;
    }

    public void setImages(ImagesDTO images) {
        this.images = images;
    }


    public ProductTypeDTO getType() {
        return type;
    }

    public void setType(ProductTypeDTO type) {
        this.type = type;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

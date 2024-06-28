package com.example.MobileShop.CommonDetailProduct;

import com.example.MobileShop.Categories.Categories;
import com.example.MobileShop.Phones.Phones;
import com.example.MobileShop.Images.Images;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.ProductSub.ProductSub;
import com.example.MobileShop.ProductType.ProductType;
import com.example.MobileShop.Review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Table(name = "CommonDetailProduct")
@Entity
public class CommonDetailProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID commonProductId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_of_goods")
    private int quantity_of_goods;

    @Column(name = "warranty")
    private int warranty;

    @Column(name = "code")
    private double code = Math.random();

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;


    @JsonIgnore
    @OneToOne(mappedBy = "commonDetailProduct", cascade = CascadeType.ALL)
    private Phones phones;

    @OneToMany(mappedBy = "commonDetailProduct", cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Images images;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Categories category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id")
    private ProductType type;

    @OneToMany(mappedBy = "commonDetailProduct", cascade = CascadeType.ALL)
    private List<ProductSub> subs;


    public CommonDetailProduct() {
    }



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

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
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

    public List<ProductSub> getSubs() {
        return subs;
    }

    public void setSubs(List<ProductSub> subs) {
        this.subs = subs;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CommonDetailProduct{" +
                "commonProductId=" + commonProductId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity_of_goods=" + quantity_of_goods +
                ", warranty=" + warranty +
                ", code=" + code +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", phones=" + phones +
                ", reviews=" + reviews +
                ", images=" + images +
                ", category=" + category +
                ", type=" + type +
                ", subs=" + subs +
                '}';
    }
}


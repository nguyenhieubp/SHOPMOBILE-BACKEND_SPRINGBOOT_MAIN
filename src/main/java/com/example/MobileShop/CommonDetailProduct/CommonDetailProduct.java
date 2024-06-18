package com.example.MobileShop.CommonDetailProduct;

import com.example.MobileShop.Categories.Categories;
import com.example.MobileShop.Phones.Phones;
import com.example.MobileShop.Images.Images;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.ProductSub.ProductSub;
import com.example.MobileShop.ProductType.ProductType;
import com.example.MobileShop.Review.Review;
import jakarta.persistence.*;
import java.util.Date;
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

    @Column(name = "product_type_id")
    private UUID product_type_id;

    @Column(name = "categories_id")
    private UUID categories_id;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    //ok
    @OneToOne(mappedBy = "commonDetailProduct", cascade = CascadeType.ALL)
    private PhoneVariable phoneVariable;

    //ok
    @OneToOne(mappedBy = "commonDetailProduct", cascade = CascadeType.ALL)
    private Phones phones;

    // OK
    @OneToMany(mappedBy = "commonDetailProduct", cascade = CascadeType.ALL)
    private Set<Review> reviews;

    // OK
    @OneToOne
    @JoinColumn(name = "image_id")
    private Images images;

    //ok
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    //ok
    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType type;

    //ok
    @ManyToOne
    @JoinColumn(name = "sub_id")
    private ProductSub sub;

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

    public UUID getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(UUID product_type_id) {
        this.product_type_id = product_type_id;
    }

    public UUID getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(UUID categories_id) {
        this.categories_id = categories_id;
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

    public PhoneVariable getPhoneVariable() {
        return phoneVariable;
    }

    public void setPhoneVariable(PhoneVariable phoneVariable) {
        this.phoneVariable = phoneVariable;
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

    public ProductSub getSub() {
        return sub;
    }

    public void setSub(ProductSub sub) {
        this.sub = sub;
    }
}


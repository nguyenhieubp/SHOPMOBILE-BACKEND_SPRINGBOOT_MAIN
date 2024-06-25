package com.example.MobileShop.Review;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.User.User;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "Review")
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "common_detail_product_id")
    private CommonDetailProduct commonDetailProduct;

    @Column(name = "comment")
    private String comment;

    @Column(name = "star")
    private float star;

    @Column(name = "review_date")
    private Date review_date;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    // Getters and setters
    public UUID getReviewId() {
        return reviewId;
    }

    public void setReviewId(UUID reviewId) {
        this.reviewId = reviewId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CommonDetailProduct getCommonDetailProduct() {
        return commonDetailProduct;
    }

    public void setCommonDetailProduct(CommonDetailProduct commonDetailProduct) {
        this.commonDetailProduct = commonDetailProduct;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
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
}

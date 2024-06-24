package com.example.MobileShop.Images;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "Images")
@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID imageId;

    @Column(name = "url")
    private String url;

    @Column(name ="created_at")
    private Date created_at = new Date();

    @Column(name ="updated_at")
    private Date updated_at = new Date();

    @OneToOne(mappedBy = "images",cascade = CascadeType.ALL)
    private CommonDetailProduct commonDetailProduct;

    // Constructors, getters, and setters
    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}

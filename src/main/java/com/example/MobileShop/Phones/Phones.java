package com.example.MobileShop.Phones;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "Phones")
@Entity
public class Phones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID phoneId;

    @OneToOne
    @JoinColumn(name = "common_detail_product_id")
    private CommonDetailProduct commonDetailProduct;


    @Column(name = "operating_system")
    private String operating_system;

    @Column(name = "phone_type")
    private String phone_type;

    @Column(name = "phone_name")
    private String phone_name;

    @Column(name = "is_show")
    private boolean is_show;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    // Getters and setters
    public UUID getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(UUID phoneId) {
        this.phoneId = phoneId;
    }

    public CommonDetailProduct getCommonDetailProduct() {
        return commonDetailProduct;
    }

    public void setCommonDetailProduct(CommonDetailProduct commonDetailProduct) {
        this.commonDetailProduct = commonDetailProduct;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public boolean isIs_show() {
        return is_show;
    }

    public void setIs_show(boolean is_show) {
        this.is_show = is_show;
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

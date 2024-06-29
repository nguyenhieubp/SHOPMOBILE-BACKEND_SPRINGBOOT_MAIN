package com.example.MobileShop.Address;


import com.example.MobileShop.User.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "Address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID addressId;

    private UUID user;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "wards")
    private String wards;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private Date created_at = new Date();

    @Column(name = "updated_at")
    private Date updated_at = new Date();

    // Getters and setters
    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "Address{" +
                "addressId=" + addressId +
                ", user=" + user +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", wards='" + wards + '\'' +
                ", address='" + address + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

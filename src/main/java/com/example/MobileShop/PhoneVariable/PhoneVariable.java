package com.example.MobileShop.PhoneVariable;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.Phones.Phones;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "PhoneVariable")
@Entity
public class PhoneVariable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID phoneVariableId;

    @Column(name = "common_product_id")
    private UUID commonDetailProduct;

    @Column(name = "phone_main_id")
    private UUID phone;

    @Column(name = "color")
    private String color;

    @Column(name = "ram")
    private String ram;

    @Column(name = "rom")
    private String rom;

    @Column(name = "disk")
    private String disk;

    @Column(name = "internal_storage")
    private String internal_storage;

    @Column(name = "release_date")
    private String release_date;

    @Column(name = "battery_capacity")
    private double battery_capacity;

    @Column(name = "camera")
    private String camera;


    @Column(name = "is_show")
    private boolean is_show;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    // Getters and setters
    public UUID getPhoneVariableId() {
        return phoneVariableId;
    }

    public void setPhoneVariableId(UUID phoneVariableId) {
        this.phoneVariableId = phoneVariableId;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public UUID getCommonDetailProduct() {
        return commonDetailProduct;
    }

    public void setCommonDetailProduct(UUID commonDetailProduct) {
        this.commonDetailProduct = commonDetailProduct;
    }

    public UUID getPhone() {
        return phone;
    }

    public void setPhone(UUID phone) {
        this.phone = phone;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getInternal_storage() {
        return internal_storage;
    }

    public void setInternal_storage(String internal_storage) {
        this.internal_storage = internal_storage;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public double getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(double battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
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

    @Override
    public String toString() {
        return "PhoneVariable{" +
                "phoneVariableId=" + phoneVariableId +
                ", commonDetailProduct=" + commonDetailProduct +
                ", phone=" + phone +
                ", color='" + color + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                ", disk='" + disk + '\'' +
                ", internal_storage='" + internal_storage + '\'' +
                ", release_date='" + release_date + '\'' +
                ", battery_capacity=" + battery_capacity +
                ", camera='" + camera + '\'' +
                ", is_show=" + is_show +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

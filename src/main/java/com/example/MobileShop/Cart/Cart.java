package com.example.MobileShop.Cart;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.User.User;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // add product
    private UUID product_item_id;
    private int quantity;
    private float price;
    private Date created_at;
    private Date updated_at;

    // Getters and setters

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getProduct_item_id() {
        return product_item_id;
    }

    public void setProduct_item_id(UUID product_item_id) {
        this.product_item_id = product_item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

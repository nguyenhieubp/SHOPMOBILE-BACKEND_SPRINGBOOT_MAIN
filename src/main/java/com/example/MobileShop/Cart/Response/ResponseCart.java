package com.example.MobileShop.Cart.Response;

import com.example.MobileShop.PhoneVariable.PhoneVariable;
import java.util.Date;
import java.util.UUID;

public class ResponseCart {

    private UUID cartId;
    private UUID user;
    private PhoneVariable product_item_id;
    private int quantity;
    private float price;
    private Date created_at = new Date();
    private Date updated_at = new Date();

    // No-argument constructor
    public ResponseCart() {
    }

    // Getters and setters
    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public PhoneVariable getProduct_item_id() {
        return product_item_id;
    }

    public void setProduct_item_id(PhoneVariable product_item_id) {
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

    @Override
    public String toString() {
        return "ResponseCart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", product_item_id=" + product_item_id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

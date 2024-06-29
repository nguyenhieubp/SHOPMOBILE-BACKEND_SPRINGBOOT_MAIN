package com.example.MobileShop.OrderDetail;

import java.util.Date;
import java.util.UUID;

public class OrderDetailDto {
    private UUID orderDetailId;

    private UUID order;

    private String phone_number;

    private int quantity;

    private float total_price;

    private UUID product_item_id;

    private Date created_at;

    private Date updated_at;

    // Các getters và setters
    public UUID getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(UUID orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public UUID getOrder() {
        return order;
    }

    public void setOrder(UUID order) {
        this.order = order;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public UUID getProduct_item_id() {
        return product_item_id;
    }

    public void setProduct_item_id(UUID product_item_id) {
        this.product_item_id = product_item_id;
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
        return "OrderDetailDto{" +
                "orderDetailId=" + orderDetailId +
                ", order=" + order +
                ", phone_number='" + phone_number + '\'' +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                ", product_item_id=" + product_item_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

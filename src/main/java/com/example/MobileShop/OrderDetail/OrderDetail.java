package com.example.MobileShop.OrderDetail;

import com.example.MobileShop.Order.Order;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "OrderDetail")
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderDetailId;

    @Column(name = "order_id")
    private UUID order;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private float total_price;

    @Column(name = "product_item_id")
    private UUID product_item_id;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    // Getters and setters
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
        return "OrderDetail{" +
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

package com.example.MobileShop.Order;

import com.example.MobileShop.OrderDetail.OrderDetail;
import com.example.MobileShop.User.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class OrderDto {
    private UUID orderId;

    private UUID user;

    private Date order_date = new Date();

    private boolean status = false;

    private UUID address_id;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getAddress_id() {
        return address_id;
    }

    public void setAddress_id(UUID address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", order_date=" + order_date +
                ", status=" + status +
                ", address_id=" + address_id +
                '}';
    }
}

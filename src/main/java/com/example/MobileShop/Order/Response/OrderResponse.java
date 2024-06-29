package com.example.MobileShop.Order.Response;

import com.example.MobileShop.Address.Address;
import com.example.MobileShop.Address.AddressDto;
import com.example.MobileShop.User.User;

import java.util.Date;
import java.util.UUID;

public class OrderResponse {
    private UUID orderId;

    private User user;

    private Date order_date = new Date();

    private boolean status = false;

    private Address address;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", order_date=" + order_date +
                ", status=" + status +
                ", address=" + address +
                '}';
    }
}

package com.example.MobileShop.OrderDetail.OrderResponse;

import com.example.MobileShop.Order.Order;
import com.example.MobileShop.Order.Response.OrderResponse;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.PhoneVariable.response.ResponsePhoneVariable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.UUID;

public class OrderDetailResponse {
    private UUID orderDetailId;

    private OrderResponse orderResponse;

    private String phone_number;

    private int quantity;

    private float total_price;

    private ResponsePhoneVariable responsePhoneVariable;

    private Date created_at = new Date();

    private Date updated_at = new Date();

    public UUID getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(UUID orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public OrderResponse getOrderResponse() {
        return orderResponse;
    }

    public void setOrderResponse(OrderResponse orderResponse) {
        this.orderResponse = orderResponse;
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

    public ResponsePhoneVariable getResponsePhoneVariable() {
        return responsePhoneVariable;
    }

    public void setResponsePhoneVariable(ResponsePhoneVariable responsePhoneVariable) {
        this.responsePhoneVariable = responsePhoneVariable;
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

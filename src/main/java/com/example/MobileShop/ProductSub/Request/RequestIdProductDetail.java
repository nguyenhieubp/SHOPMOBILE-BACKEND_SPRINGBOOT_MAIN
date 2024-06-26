package com.example.MobileShop.ProductSub.Request;

import java.util.UUID;

public class RequestIdProductDetail {
    private UUID productDetailId;

    public UUID getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(UUID productDetailId) {
        this.productDetailId = productDetailId;
    }

    @Override
    public String toString() {
        return "RequestIdProductDetail{" +
                "productDetailId=" + productDetailId +
                '}';
    }
}

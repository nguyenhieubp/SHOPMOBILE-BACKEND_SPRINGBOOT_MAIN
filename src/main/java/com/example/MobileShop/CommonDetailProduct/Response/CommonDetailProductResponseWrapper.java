package com.example.MobileShop.CommonDetailProduct.Response;

import org.springframework.data.domain.Page;

import java.util.List;

public class CommonDetailProductResponseWrapper {
    private long count;
    private Page<CommonDetailProductResponse> products;

    public CommonDetailProductResponseWrapper(long count, Page<CommonDetailProductResponse> products) {
        this.count = count;
        this.products = products;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Page<CommonDetailProductResponse> getProducts() {
        return products;
    }

    public void setProducts(Page<CommonDetailProductResponse> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CommonDetailProductResponseWrapper{" +
                "count=" + count +
                ", products=" + products +
                '}';
    }
}

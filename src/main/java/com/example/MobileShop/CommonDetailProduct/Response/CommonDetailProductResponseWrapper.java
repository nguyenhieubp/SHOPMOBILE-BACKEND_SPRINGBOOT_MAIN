package com.example.MobileShop.CommonDetailProduct.Response;

import java.util.List;

public class CommonDetailProductResponseWrapper {
    private long count;
    private List<CommonDetailProductResponse> products;

    public CommonDetailProductResponseWrapper(long count, List<CommonDetailProductResponse> products) {
        this.count = count;
        this.products = products;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<CommonDetailProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<CommonDetailProductResponse> products) {
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

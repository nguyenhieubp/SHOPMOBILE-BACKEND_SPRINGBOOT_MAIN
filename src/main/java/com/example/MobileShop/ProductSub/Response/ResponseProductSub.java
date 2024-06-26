package com.example.MobileShop.ProductSub.Response;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;

import java.util.Date;
import java.util.UUID;

public class ResponseProductSub {
    private UUID productSubId;

    private String key;

    private String value;

    private CommonDetailProduct commonDetailProduct;

    private Date created_at = new Date();

    private Date updated_at = new Date();

    public UUID getProductSubId() {
        return productSubId;
    }

    public void setProductSubId(UUID productSubId) {
        this.productSubId = productSubId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public CommonDetailProduct getCommonDetailProduct() {
        return commonDetailProduct;
    }

    public void setCommonDetailProduct(CommonDetailProduct commonDetailProduct) {
        this.commonDetailProduct = commonDetailProduct;
    }

    @Override
    public String toString() {
        return "ResponseProductSub{" +
                "productSubId=" + productSubId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", commonDetailProduct=" + commonDetailProduct +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

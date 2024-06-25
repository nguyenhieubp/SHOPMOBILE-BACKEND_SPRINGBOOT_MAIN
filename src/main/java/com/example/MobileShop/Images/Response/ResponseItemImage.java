package com.example.MobileShop.Images.Response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

public class ResponseItemImage {
    private UUID imageId;

    private String url;

    private Date created_at = new Date();

    private Date updated_at = new Date();

    public ResponseItemImage() {}

    public ResponseItemImage(UUID imageId, String url, Date created_at, Date updated_at) {
        this.imageId = imageId;
        this.url = url;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "ResponseItemImage{" +
                "imageId=" + imageId +
                ", url='" + url + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

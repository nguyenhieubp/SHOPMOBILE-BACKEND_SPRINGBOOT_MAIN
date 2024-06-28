package com.example.MobileShop.Images;

import java.util.Date;
import java.util.UUID;

public class ImagesDTO {
    private UUID imageId;
    private String url;
    private Date created_at;
    private Date updated_at;

    // Getters and setters
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
        return "ImagesDTO{" +
                "imageId=" + imageId +
                ", url='" + url + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

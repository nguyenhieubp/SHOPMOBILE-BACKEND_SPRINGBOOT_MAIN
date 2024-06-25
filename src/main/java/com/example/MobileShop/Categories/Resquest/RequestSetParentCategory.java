package com.example.MobileShop.Categories.Resquest;

import java.util.UUID;

public class RequestSetParentCategory {
    private UUID categoryParent;

    public UUID getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(UUID categoryParent) {
        this.categoryParent = categoryParent;
    }

    @Override
    public String toString() {
        return "RequestSetParentCategory{" +
                "categoryParent=" + categoryParent +
                '}';
    }
}

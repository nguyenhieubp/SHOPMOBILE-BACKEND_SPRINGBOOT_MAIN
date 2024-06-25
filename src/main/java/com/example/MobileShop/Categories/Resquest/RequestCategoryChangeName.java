package com.example.MobileShop.Categories.Resquest;

public class RequestCategoryChangeName {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestCategoryChangeName{" +
                "name='" + name + '\'' +
                '}';
    }
}

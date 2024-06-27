package com.example.MobileShop.CommonDetailProduct.Request;

public class ChangeQuantityOfGoods {
    private int quantity;
    private String calc;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCalc() {
        return calc;
    }

    public void setCalc(String calc) {
        this.calc = calc;
    }

    @Override
    public String toString() {
        return "ChangeQuantityOfGoods{" +
                "quantity=" + quantity +
                ", calc='" + calc + '\'' +
                '}';
    }
}

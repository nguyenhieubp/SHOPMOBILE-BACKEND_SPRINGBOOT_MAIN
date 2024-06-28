package com.example.MobileShop.PhoneVariable.response;

import com.example.MobileShop.CommonDetailProduct.CommonDetailProduct;
import com.example.MobileShop.PhoneVariable.PhoneVariable;
import com.example.MobileShop.PhoneVariable.PhoneVariableDTO;

public class ResponsePhoneVariable {
    private PhoneVariable phoneVariable;

    private CommonDetailProduct commonDetailProduct;

    public ResponsePhoneVariable(PhoneVariable phoneVariable, CommonDetailProduct commonDetailProduct) {
        this.phoneVariable = phoneVariable;
        this.commonDetailProduct = commonDetailProduct;
    }

    public PhoneVariable getPhoneVariable() {
        return phoneVariable;
    }

    public void setPhoneVariable(PhoneVariable phoneVariable) {
        this.phoneVariable = phoneVariable;
    }

    public CommonDetailProduct getCommonDetailProduct() {
        return commonDetailProduct;
    }

    public void setCommonDetailProduct(CommonDetailProduct commonDetailProduct) {
        this.commonDetailProduct = commonDetailProduct;
    }

    @Override
    public String toString() {
        return "ResponsePhoneVariable{" +
                "phoneVariable=" + phoneVariable +
                ", commonDetailProduct=" + commonDetailProduct +
                '}';
    }
}

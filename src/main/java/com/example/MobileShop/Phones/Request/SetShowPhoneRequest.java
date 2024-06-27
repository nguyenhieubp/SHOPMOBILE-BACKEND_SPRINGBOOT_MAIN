package com.example.MobileShop.Phones.Request;

public class SetShowPhoneRequest {
    private boolean setShow;

    public SetShowPhoneRequest() {
    }

    public SetShowPhoneRequest(boolean setShow) {
        this.setShow = setShow;
    }

    public boolean isSetShow() {
        return setShow;
    }

    public void setSetShow(boolean setShow) {
        this.setShow = setShow;
    }

    @Override
    public String toString() {
        return "SetShowDetailCommonProduct{" +
                "setShow=" + setShow +
                '}';
    }
}

package com.github.sidneymiranda.lojavirtual.enums;

public enum AddressType {

    TO_CHARGE("ToCharge"),
    DELIVERY("Delivery");

    private String description;

    AddressType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}

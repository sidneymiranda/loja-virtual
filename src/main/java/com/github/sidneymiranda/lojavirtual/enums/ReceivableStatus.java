package com.github.sidneymiranda.lojavirtual.enums;

public enum ReceivableStatus {

    CHARGE("Charge"),
    EXPIRED("Expired"),
    OPEN("Open"),
    PAID_OFF("Paid off");

    private String description;

    ReceivableStatus(String description) {
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

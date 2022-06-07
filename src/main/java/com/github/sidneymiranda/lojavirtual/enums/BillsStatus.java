package com.github.sidneymiranda.lojavirtual.enums;

public enum BillsStatus {

    CHARGE("Charge"),
    EXPIRED("Expired"),
    OPEN("Open"),
    PAID_OFF("Paid off"),
    RENEGOTIATED("Renegotiated");

    private String description;

    BillsStatus(String description) {
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

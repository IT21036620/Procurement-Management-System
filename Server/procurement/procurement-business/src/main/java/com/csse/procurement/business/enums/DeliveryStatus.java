package com.csse.procurement.business.enums;

public enum DeliveryStatus {
    PENDING("PENDING"),
    DISPATCHED("DISPATCHED"),
    PARTIAL("PARTIAL"),
    COMPLETED("COMPLETED"),
    FAILED("FAILED");

    DeliveryStatus(String status) {
        this.status = status;
    }

    private final String status;
}

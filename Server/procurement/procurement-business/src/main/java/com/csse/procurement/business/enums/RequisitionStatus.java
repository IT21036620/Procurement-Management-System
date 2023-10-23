package com.csse.procurement.business.enums;

public enum RequisitionStatus {
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED"),
    PARTIAL("PARTIAL"),
    REJECTED("REJECTED");

    RequisitionStatus(String status) {
        this.status = status;
    }

    private final String status;
}

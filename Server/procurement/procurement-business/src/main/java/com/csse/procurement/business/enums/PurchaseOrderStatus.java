package com.csse.procurement.business.enums;

public enum PurchaseOrderStatus {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    DECLINED("DECLINED"),
    PLACED("PLACED"),
    URGENT("URGENT"),
    DRAFT("DRAFT");

    PurchaseOrderStatus(String status) {
        this.status = status;
    }

    private final String status;
}

package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrder extends BaseEntity {
    private String poReference;
    private String status;
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "siteManagerId")
    private SiteManager siteManager;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "purchaseOrderId")
    private List<PurchaseOrderItem> purchaseOrderItemList;
}

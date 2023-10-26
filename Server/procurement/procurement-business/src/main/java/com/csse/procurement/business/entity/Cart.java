package com.csse.procurement.business.entity;

import com.csse.procurement.business.enums.PurchaseOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntity {
    private Long id;
    private Double totalPrice;
    private SiteManager siteManager;
    private List<PurchaseOrderItem> purchaseOrderItemList;
}

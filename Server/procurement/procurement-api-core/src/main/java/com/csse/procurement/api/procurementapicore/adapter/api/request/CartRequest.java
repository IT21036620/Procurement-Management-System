package com.csse.procurement.api.procurementapicore.adapter.api.request;

import com.csse.hexa.core.Request;
import com.csse.procurement.business.entity.PurchaseOrderItem;
import lombok.Getter;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Getter
public class CartRequest implements Request {
    private Long siteManager;
    private List<PurchaseOrderItem> purchaseOrderItemList;
}

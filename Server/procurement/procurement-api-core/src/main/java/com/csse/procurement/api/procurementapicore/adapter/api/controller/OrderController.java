package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.api.procurementapicore.adapter.api.request.CartRequest;
import com.csse.procurement.api.procurementapicore.adapter.api.response.CommonResponse;
import com.csse.procurement.business.entity.Cart;
import com.csse.procurement.business.entity.PurchaseOrder;
import com.csse.procurement.business.entity.Requisition;
import com.csse.procurement.business.entity.SiteManager;
import com.csse.procurement.business.port.in.OrderUseCase;
import com.csse.procurement.business.port.in.SiteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderUseCase orderService;
    private final SiteUseCase siteService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public OrderController(OrderUseCase orderService, SiteUseCase siteService) {
        this.orderService = orderService;
        this.siteService = siteService;
    }

    @PostMapping
    public ResponseEntity<String> createPurchaseOrder(@RequestBody final PurchaseOrder purchaseOrder) {
        orderService.createPurchaseOrder(purchaseOrder);
        return ResponseEntity.ok(null);
    }

    @PatchMapping
    public ResponseEntity<CommonResponse> updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        orderService.updatePurchaseOrder(purchaseOrder);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated purchase order with id: " + purchaseOrder.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deletePurchaseOrderById(@PathVariable Long id) {
        orderService.deletePurchaseOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully purchase order with id: " + id));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllPurchaseOrders() {
        return ResponseEntity.ok(new CommonResponse(orderService.getAllPurchaseOrders()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getPurchaseOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(orderService.getPurchaseOrderById(id)));
    }

    @PostMapping("/requisition")
    public ResponseEntity<String> createRequisition(@RequestBody final Requisition requisition) {
        orderService.createRequisition(requisition);
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/requisition")
    public ResponseEntity<CommonResponse> updateRequisition(@RequestBody Requisition requisition) {
        orderService.updateRequisition(requisition);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated requisition with id: " + requisition.getId()));
    }

    @DeleteMapping("/requisition/{id}")
    public ResponseEntity<CommonResponse> deleteRequisitionById(@PathVariable Long id) {
        orderService.deleteRequisitionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted requisition with id: " + id));
    }

    @GetMapping("/requisition")
    public ResponseEntity<CommonResponse> getAllRequisitions() {
        return ResponseEntity.ok(new CommonResponse(orderService.getAllRequisitions()));
    }

    @GetMapping("requisition/{id}")
    public ResponseEntity<CommonResponse> getRequisitionById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(orderService.getRequisitionById(id)));
    }

    @PostMapping("/cart")
    public ResponseEntity<String> createCart(@RequestBody final CartRequest cartRequest) {
        SiteManager siteManager = siteService.getSiteManagerById(cartRequest.getSiteManager());
        Double totalPrice = 0.00;
        Cart cart = new Cart();
        cart.setSiteManager(siteManager);
        cart.setPurchaseOrderItemList(cartRequest.getPurchaseOrderItemList());
        cart.setTotalPrice(totalPrice);
        orderService.createCart(cart);
        return ResponseEntity.ok(null);
    }

    @GetMapping("cart/{id}")
    public ResponseEntity<CommonResponse> getCartById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(orderService.getCartById(id)));
    }

    @GetMapping("cart/site-manager/{id}")
    public ResponseEntity<CommonResponse> getCartBySiteManagerId(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(orderService.getCartBySiteManagerId(id)));
    }
}

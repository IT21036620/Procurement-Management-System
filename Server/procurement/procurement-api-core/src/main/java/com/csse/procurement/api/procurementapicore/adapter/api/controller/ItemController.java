package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.api.procurementapicore.adapter.api.response.CommonResponse;
import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Supplier;
import com.csse.procurement.business.port.in.ItemUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemUseCase itemService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public ItemController(ItemUseCase itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody final Item item) {
        itemService.createItem(item);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated item with id: " + item.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully item with id: " + id));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllItems() {
        return ResponseEntity.ok(new CommonResponse(itemService.getAllItems()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(itemService.getItemById(id)));
    }

    @PostMapping("/supplier")
    public ResponseEntity<String> createSupplier(@RequestBody final Supplier supplier) {
        itemService.createSupplier(supplier);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/supplier")
    public ResponseEntity<CommonResponse> updateSupplier(@RequestBody Supplier supplier) {
        itemService.updateSupplier(supplier);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated supplier with id: " + supplier.getId()));
    }

    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<CommonResponse> deleteSupplierById(@PathVariable Long id) {
        itemService.deleteSupplierById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted supplier with id: " + id));
    }

    @GetMapping("/supplier")
    public ResponseEntity<CommonResponse> getAllSuppliers() {
        return ResponseEntity.ok(new CommonResponse(itemService.getAllSupplier()));
    }

    @GetMapping("supplier/{id}")
    public ResponseEntity<CommonResponse> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(itemService.getSupplierById(id)));
    }
}

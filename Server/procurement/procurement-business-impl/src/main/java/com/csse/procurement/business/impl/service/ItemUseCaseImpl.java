package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Supplier;
import com.csse.procurement.business.exception.BusinessLogicException;
import com.csse.procurement.business.port.in.ItemUseCase;
import com.csse.procurement.business.port.out.GetItemPort;
import com.csse.procurement.business.port.out.GetSupplierPort;
import com.csse.procurement.business.port.out.SaveItemPort;
import com.csse.procurement.business.port.out.SaveSupplierPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemUseCaseImpl implements ItemUseCase {
    private static final String ITEM_NOT_FOUND = "Item not found";
    private static final String SUPPLIER_NOT_FOUND = "Supplier not found";

    @Autowired
    private SaveItemPort saveItemPort;
    @Autowired
    private GetItemPort getItemPort;
    @Autowired
    private SaveSupplierPort saveSupplierPort;
    @Autowired
    private GetSupplierPort getSupplierPort;

    @Override
    public void createItem(Item item) {
        saveItemPort.createItem(item);
    }

    @Override
    public void updateItem(Item item) {
        Item existingItem = getItemPort.getItemById(item.getId());

        if (existingItem == null) {
            throw new BusinessLogicException(ITEM_NOT_FOUND);
        }

        saveItemPort.updateItem(item);
    }

    @Override
    public void deleteItemById(Long id) {
        saveItemPort.deleteItemById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return getItemPort.getAllItems();
    }

    @Override
    public Item getItemById(Long id) {
        return getItemPort.getItemById(id);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        saveSupplierPort.createSupplier(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        Supplier existingSupplier = getSupplierPort.getSupplierById(supplier.getId());

        if (existingSupplier == null) {
            throw new BusinessLogicException(SUPPLIER_NOT_FOUND);
        }

        saveSupplierPort.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplierById(Long id) {
        saveSupplierPort.deleteSupplierById(id);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return getSupplierPort.getAllSupplier();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return getSupplierPort.getSupplierById(id);
    }
}

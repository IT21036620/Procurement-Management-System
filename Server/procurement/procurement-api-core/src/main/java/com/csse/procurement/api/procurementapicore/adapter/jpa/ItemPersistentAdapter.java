package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company;
import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department;
import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.ItemRepository;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.SupplierRepository;
import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.Supplier;
import com.csse.procurement.business.entity.SystemAdmin;
import com.csse.procurement.business.port.out.GetItemPort;
import com.csse.procurement.business.port.out.GetSupplierPort;
import com.csse.procurement.business.port.out.SaveItemPort;
import com.csse.procurement.business.port.out.SaveSupplierPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemPersistentAdapter implements SaveItemPort, GetItemPort, SaveSupplierPort, GetSupplierPort {
    private final ItemRepository itemRepository;
    private final SupplierRepository supplierRepository;
    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public ItemPersistentAdapter(ItemRepository itemRepository, SupplierRepository supplierRepository) {
        this.itemRepository = itemRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void createItem(Item item) {
        if (item != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Item dbItem = mapper.map(item, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Item.class);

            if (item.getSupplier() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier dbSupplier = supplierRepository.findById(item.getSupplier().getId()).orElse(null);
                dbItem.setSupplier(dbSupplier);
            }
            itemRepository.save(dbItem);
        }
    }

    @Override
    public void updateItem(Item item) {
        Long itemId = item.getId();

        if (itemId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Item existingItem = optionalItem.get();

            existingItem.setName(item.getName());
            existingItem.setDescription(item.getDescription());
            existingItem.setPrice(item.getPrice());
            existingItem.setImage(item.getImage());
            existingItem.setCategory(item.getCategory());

            if (item.getSupplier() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier supplier = supplierRepository.findById(item.getSupplier().getId()).orElse(null);
                existingItem.setSupplier(supplier);
            }

            itemRepository.save(existingItem);
        }
    }

    @Override
    public void deleteItemById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Item> optionalItem = itemRepository.findById(id);

        if (optionalItem.isPresent()) {
            itemRepository.deleteById(id);
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll().stream().map(n->mapper.map(n, Item.class)).toList();
    }

    @Override
    public Item getItemById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Item> item = itemRepository.findById(id);
        return mapper.map(item, Item.class);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        if (supplier != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier dbSupplier = mapper.map(supplier, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier.class);
            supplierRepository.save(dbSupplier);
        }
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        Long supplierId = supplier.getId();

        if (supplierId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier existingSupplier = optionalSupplier.get();

            existingSupplier.setSupplierName(supplier.getSupplierName());
            existingSupplier.setAddress(supplier.getAddress());
            existingSupplier.setEmail(supplier.getEmail());
            existingSupplier.setContactNo(supplier.getContactNo());

            supplierRepository.save(existingSupplier);
        }
    }

    @Override
    public void deleteSupplierById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            supplierRepository.deleteById(id);
        }
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll().stream().map(n->mapper.map(n, Supplier.class)).toList();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier> supplier = supplierRepository.findById(id);
        return mapper.map(supplier, Supplier.class);
    }
}

package com.csse.procurement.api.procurementapicore.adapter.jpa.repository;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}

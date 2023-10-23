package com.csse.procurement.api.procurementapicore.adapter.jpa.repository;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SystemAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAdminRepository extends JpaRepository<SystemAdmin, Long> {
}

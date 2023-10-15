package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Policy;

import java.util.List;

public interface GetPolicyPort {
    /**
     * Get all policies
     * @return - List of policies
     */
    List<Policy> getAllPolicies();

    /**
     * Get policy by id
     * @param id - policy id
     * @return - policy
     */
    Policy getPolicyById(Long id);
}

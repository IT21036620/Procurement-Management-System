package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Policy;

public interface SavePolicyPort {
    /**
     * Create policy
     * @param policy - policy
     */
    void createPolicy(Policy policy);

    /**
     * Update policy
     * @param policy - policy
     */
    void updatePolicy(Policy policy);

    /**
     * Delete policy
     * @param id - policy id
     */
    void deletePolicyById(Long id);
}

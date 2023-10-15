package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Policy;

public interface SaveLineManagerPort {
    /**
     * Create line manager
     * @param lineManager - line manager
     */
    void createLineManager(LineManager lineManager);

    /**
     * Update line manager
     * @param lineManager - line manager
     */
    void updateLineManager(LineManager lineManager);

    /**
     * Delete line manager
     * @param id - line manager id
     */
    void deleteLineManagerById(Long id);
}

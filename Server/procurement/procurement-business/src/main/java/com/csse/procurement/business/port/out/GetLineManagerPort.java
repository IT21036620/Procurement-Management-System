package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Policy;

import java.util.List;

public interface GetLineManagerPort {
    /**
     * Get all line managers
     * @return - List of line managers
     */
    List<LineManager> getAllLineManagers();

    /**
     * Get line manager by id
     * @param id - line manager id
     * @return - line manager
     */
    Policy getLineManagerById(Long id);
}

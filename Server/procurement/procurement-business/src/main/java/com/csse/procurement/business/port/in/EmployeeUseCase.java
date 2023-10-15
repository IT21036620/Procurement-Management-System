package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Policy;

import java.util.List;

@UseCase
public interface EmployeeUseCase {
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

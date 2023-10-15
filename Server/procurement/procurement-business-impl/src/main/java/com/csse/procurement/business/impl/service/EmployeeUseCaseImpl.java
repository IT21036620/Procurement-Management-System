package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Policy;
import com.csse.procurement.business.port.in.EmployeeUseCase;
import com.csse.procurement.business.port.out.GetLineManagerPort;
import com.csse.procurement.business.port.out.SaveLineManagerPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeUseCaseImpl implements EmployeeUseCase {
    private static final String LINE_MANAGER_NOT_FOUND = "Line manager not found";

    @Autowired
    private SaveLineManagerPort saveLineManagerPort;
    @Autowired
    private GetLineManagerPort getLineManagerPort;

    @Override
    public void createLineManager(LineManager lineManager) {

    }

    @Override
    public void updateLineManager(LineManager lineManager) {

    }

    @Override
    public void deleteLineManagerById(Long id) {

    }

    @Override
    public List<LineManager> getAllLineManagers() {
        return null;
    }

    @Override
    public Policy getLineManagerById(Long id) {
        return null;
    }
}

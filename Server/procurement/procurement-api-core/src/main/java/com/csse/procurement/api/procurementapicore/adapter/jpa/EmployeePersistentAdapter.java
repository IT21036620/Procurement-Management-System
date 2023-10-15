package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.LineManagerRepository;
import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Policy;
import com.csse.procurement.business.port.out.GetLineManagerPort;
import com.csse.procurement.business.port.out.SaveLineManagerPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeePersistentAdapter implements SaveLineManagerPort, GetLineManagerPort {
    private final LineManagerRepository lineManagerRepository;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public EmployeePersistentAdapter(LineManagerRepository lineManagerRepository) {
        this.lineManagerRepository = lineManagerRepository;
    }

    @Override
    public List<LineManager> getAllLineManagers() {
        return null;
    }

    @Override
    public Policy getLineManagerById(Long id) {
        return null;
    }

    @Override
    public void createLineManager(LineManager lineManager) {

    }

    @Override
    public void updateLineManager(LineManager lineManager) {

    }

    @Override
    public void deleteLineManagerById(Long id) {

    }
}

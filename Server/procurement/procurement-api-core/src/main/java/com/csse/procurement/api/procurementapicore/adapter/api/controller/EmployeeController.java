package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.api.procurementapicore.adapter.api.response.CommonResponse;
import com.csse.procurement.business.entity.*;
import com.csse.procurement.business.port.in.EmployeeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeUseCase employeeService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public EmployeeController(EmployeeUseCase employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/line-manager")
    public ResponseEntity<String> createLineManager(@RequestBody final LineManager lineManager) {
        employeeService.createLineManager(lineManager);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/line-manager")
    public ResponseEntity<CommonResponse> updateLineManager(@RequestBody LineManager lineManager) {
        employeeService.updateLineManager(lineManager);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated line manager with id: " + lineManager.getId()));
    }

    @DeleteMapping("/line-manager/{id}")
    public ResponseEntity<CommonResponse> deleteLineManagerById(@PathVariable Long id) {
        employeeService.deleteLineManagerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted line manager with id: " + id));
    }

    @GetMapping("/line-manager")
    public ResponseEntity<CommonResponse> getAllLineManagers() {
        return ResponseEntity.ok(new CommonResponse(employeeService.getAllLineManagers()));
    }

    @GetMapping("/line-manager/{id}")
    public ResponseEntity<CommonResponse> getLineManagerById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(employeeService.getLineManagerById(id)));
    }

    @PostMapping("/system-admin")
    public ResponseEntity<String> createSystemAdmin(@RequestBody final SystemAdmin systemAdmin) {
        employeeService.createSystemAdmin(systemAdmin);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/system-admin")
    public ResponseEntity<CommonResponse> updateSystemAdmin(@RequestBody SystemAdmin systemAdmin) {
        employeeService.updateSystemAdmin(systemAdmin);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated system admin with id: " + systemAdmin.getId()));
    }

    @DeleteMapping("/system-admin/{id}")
    public ResponseEntity<CommonResponse> deleteSystemAdminById(@PathVariable Long id) {
        employeeService.deleteSystemAdminById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted system admin with id: " + id));
    }

    @GetMapping("/system-admin")
    public ResponseEntity<CommonResponse> getAllSystemAdmins() {
        return ResponseEntity.ok(new CommonResponse(employeeService.getAllSystemAdmins()));
    }

    @GetMapping("/system-admin/{id}")
    public ResponseEntity<CommonResponse> getSystemAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(employeeService.getSystemAdminById(id)));
    }

    @PostMapping("/accounting-officer")
    public ResponseEntity<String> createAccountingOfficer(@RequestBody final AccountingOfficer accountingOfficer) {
        employeeService.createAccountingOfficer(accountingOfficer);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/accounting-officer")
    public ResponseEntity<CommonResponse> updateAccountingOfficer(@RequestBody AccountingOfficer accountingOfficer) {
        employeeService.updateAccountingOfficer(accountingOfficer);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated accounting officer with id: " + accountingOfficer.getId()));
    }

    @DeleteMapping("/accounting-officer/{id}")
    public ResponseEntity<CommonResponse> deleteAccountingOfficerById(@PathVariable Long id) {
        employeeService.deleteAccountingOfficerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted accounting officer with id: " + id));
    }

    @GetMapping("/accounting-officer")
    public ResponseEntity<CommonResponse> getAllAccountingOfficers() {
        return ResponseEntity.ok(new CommonResponse(employeeService.getAllAccountingOfficers()));
    }

    @GetMapping("/accounting-officer/{id}")
    public ResponseEntity<CommonResponse> getAccountingOfficerById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(employeeService.getAccountingOfficerById(id)));
    }

    @PostMapping("/procurement-officer")
    public ResponseEntity<String> createProcurementOfficer(@RequestBody final ProcurementOfficer procurementOfficer) {
        employeeService.createProcurementOfficer(procurementOfficer);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/procurement-officer")
    public ResponseEntity<CommonResponse> updateProcurementOfficer(@RequestBody ProcurementOfficer procurementOfficer) {
        employeeService.updateProcurementOfficer(procurementOfficer);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated procurement officer with id: " + procurementOfficer.getId()));
    }

    @DeleteMapping("/procurement-officer/{id}")
    public ResponseEntity<CommonResponse> deleteProcurementOfficerById(@PathVariable Long id) {
        employeeService.deleteProcurementOfficerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted procurement officer with id: " + id));
    }

    @GetMapping("/procurement-officer")
    public ResponseEntity<CommonResponse> getAllProcurementOfficers() {
        return ResponseEntity.ok(new CommonResponse(employeeService.getAllProcurementOfficers()));
    }

    @GetMapping("/procurement-officer/{id}")
    public ResponseEntity<CommonResponse> getProcurementOfficerById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(employeeService.getProcurementOfficerById(id)));
    }
}

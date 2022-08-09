package com.infosys.bnsf.timetrackerassist.controller;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Employee;
import com.infosys.bnsf.timetrackerassist.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employee/findall")
    public ResponseEntity<List<Employee>> findAllApplications() {

        return ResponseEntity.ok().body(service.getAllEmployees());
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.getEmployeeById(empId));
    }

    @PostMapping("/employee/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) throws Exception {

        return ResponseEntity.ok().body(service.createEmployee(employee));
    }

    @PutMapping("/employee/update")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.updateEmployee(employee, employee.getEmpId()));
    }

    @DeleteMapping("/employee/delete/{empId}")
    public ResponseEntity<Object> deleteApplicationById(@PathVariable Long empId) throws ResourceNotFoundException {

        service.deleteEmployee(empId);
        return ResponseEntity.ok().body("Employee with ID: " + empId + " deleted.");
    }
}

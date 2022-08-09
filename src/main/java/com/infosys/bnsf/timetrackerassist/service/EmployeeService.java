package com.infosys.bnsf.timetrackerassist.service;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Employee;
import com.infosys.bnsf.timetrackerassist.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee getEmployeeById(Long empId) throws ResourceNotFoundException {

        Optional<Employee> foundEmployee = repo.findById(empId);

        if(foundEmployee.isEmpty()){
            throw new ResourceNotFoundException("Employee by ID " + empId + " does not exist.");
        }

        return foundEmployee.get();
    }

    // Create
    public Employee createEmployee(Employee employee) {

        employee.setEmpId(-1L);
        return repo.save(employee);
    }

    // Update
    public Employee updateEmployee(Employee employee, Long empId) throws ResourceNotFoundException {

        Optional<Employee> foundEmployee = repo.findById(empId);

        if (foundEmployee.isEmpty()) {

            throw new ResourceNotFoundException("Employee with ID " + empId + " does not exist, no records were updated.");
        }

        Employee editEmployee = foundEmployee.get();
        editEmployee.setcId(employee.getcId());
        editEmployee.setEmpName(employee.getEmpName());
        editEmployee.setAccess(employee.getAccess());
        editEmployee.setGroupId(employee.getGroupId());
        editEmployee.setMaintId(employee.getMaintId());
        editEmployee.setMaintTs(employee.getMaintTs());

        return repo.save(editEmployee);
    }

    // Delete
    public void deleteEmployee(Long empId) throws ResourceNotFoundException {

        Optional<Employee> foundEmployee = repo.findById(empId);

        if(foundEmployee.isEmpty()) {
            throw new ResourceNotFoundException("Employee does not exist, no records were deleted.");
        }

        repo.deleteById(empId);
    }
}

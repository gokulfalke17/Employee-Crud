package com.techpulse.service;

import com.techpulse.entity.Employee;
import com.techpulse.exception.EmployeeNotFoundException;
import com.techpulse.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployees(Integer empId) {
        return repository.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with id :: "+ empId));
    }

    @Override
    public Employee updateEmployee(Integer empId, Employee newEmployee) {
        Employee oldEmployee = repository.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("Cannot, update! Employee Not Found :: " + empId));
        newEmployee.setEmpId(empId);
        return repository.save(newEmployee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        if(!repository.existsById(empId)) {
            throw new EmployeeNotFoundException("Cannot Delete! Employee Not Found :: "+ empId);
        }
        repository.deleteById(empId);
    }
}

package com.techpulse.service;

import com.techpulse.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public Employee addEmployee(Employee employee);
    public List<Employee> getEmployees();
    public Employee getEmployees(Integer empId);
    public Employee updateEmployee(Integer empId, Employee newEmployee);
    public void deleteEmployee(Integer empId);

}

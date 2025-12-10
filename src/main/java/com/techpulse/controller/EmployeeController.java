package com.techpulse.controller;

import com.techpulse.entity.Employee;
import com.techpulse.response.ApiResponse;
import com.techpulse.service.IEmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @PostMapping
    public ResponseEntity<ApiResponse> addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = service.addEmployee(employee);
        return  ResponseEntity.ok(
                new ApiResponse(true, "Employee Added Successfully...", addedEmployee)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getEmployees() {
        List<Employee> list = service.getEmployees();
        return ResponseEntity.ok(
                new ApiResponse(true, "Employees are Available", list)
        );
    }

    @GetMapping("/{empId}")
    public ResponseEntity<ApiResponse> getEmployees(@PathVariable Integer empId) {
        Employee employee = service.getEmployees(empId);
        return ResponseEntity.ok(
                new ApiResponse(true, "Employee Found", employee)
        );
    }


    @PutMapping("/{empId}")
    public ResponseEntity<ApiResponse> updateEmployee(@PathVariable Integer empId, @RequestBody Employee newEmployee) {
        Employee updatedEmployee = service.updateEmployee(empId, newEmployee);
        return  ResponseEntity.ok(
                new ApiResponse(true, "Employee Updated Successfully...", updatedEmployee)
        );
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Integer empId) {
        service.deleteEmployee(empId);
        return  ResponseEntity.ok(
            new ApiResponse(true, "Employee Deleted Successfully...", null)
        );
    }

}

package com.techpulse.dto;

import lombok.Data;

@Data
public class EmployeeResponseDTO {

    private Integer empId;
    private String empName;
    private Integer salary;
    private String email;
    private String dept;
}

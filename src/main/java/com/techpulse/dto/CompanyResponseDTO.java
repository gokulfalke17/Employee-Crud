package com.techpulse.dto;

import lombok.Data;
import java.util.List;

@Data
public class CompanyResponseDTO {

    private Integer companyId;
    private String companyName;
    private Integer noOfEmployees;

    private List<EmployeeResponseDTO> employees;

}

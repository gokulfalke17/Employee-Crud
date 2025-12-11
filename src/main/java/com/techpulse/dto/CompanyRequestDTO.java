package com.techpulse.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompanyRequestDTO {

    @Size(max = 50)
    @NotBlank
    private String companyName;

    @NotNull
    private Integer noOfEmployees;

}


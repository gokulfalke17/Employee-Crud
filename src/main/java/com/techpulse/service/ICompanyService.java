package com.techpulse.service;

import com.techpulse.dto.CompanyRequestDTO;
import com.techpulse.dto.CompanyResponseDTO;

import java.util.List;

public interface ICompanyService {

    public CompanyResponseDTO addCompany(CompanyRequestDTO dto);
    public List<CompanyResponseDTO> getCompanies();
    public CompanyResponseDTO getCompanies(Integer id);
    public CompanyResponseDTO updateCompanyDetails(Integer id, CompanyRequestDTO dto);
    public void deleteCompany(Integer id);
}

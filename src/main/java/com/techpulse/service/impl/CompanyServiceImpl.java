package com.techpulse.service.impl;

import com.techpulse.dto.CompanyRequestDTO;
import com.techpulse.dto.CompanyResponseDTO;
import com.techpulse.dto.EmployeeResponseDTO;
import com.techpulse.entity.Company;
import com.techpulse.exception.CompanyNotAvailableException;
import com.techpulse.mapper.CompanyMapper;
import com.techpulse.mapper.EmployeeMapper;
import com.techpulse.repository.ICompanyRepository;
import com.techpulse.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepository repository;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private EmployeeMapper employeeMapper;   // IMPORTANT

    @Override
    public CompanyResponseDTO addCompany(CompanyRequestDTO dto) {
        Company company = companyMapper.toEntity(dto);
        Company saved = repository.save(company);
        return companyMapper.toDTO(saved);
    }

    @Override
    public List<CompanyResponseDTO> getCompanies() {
        return repository.findAll()
                .stream()
                .map(company -> {
                    CompanyResponseDTO dto = companyMapper.toDTO(company);

                    // Set employees list
                    dto.setEmployees(
                            company.getEmployees()
                                    .stream()
                                    .map(employeeMapper::toDTO)
                                    .collect(Collectors.toList())
                    );

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponseDTO getCompanies(Integer id) {
        Company company = repository.findById(id)
                .orElseThrow(() -> new CompanyNotAvailableException("Company Not Found :: " + id));

        CompanyResponseDTO dto = companyMapper.toDTO(company);

        // Add employee list
        dto.setEmployees(
                company.getEmployees()
                        .stream()
                        .map(employeeMapper::toDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    @Override
    public CompanyResponseDTO updateCompanyDetails(Integer id, CompanyRequestDTO dto) {
        Company oldCompany = repository.findById(id)
                .orElseThrow(() -> new CompanyNotAvailableException("Cannot update! Company Not Found :: " + id));

        oldCompany.setCompanyName(dto.getCompanyName());
        oldCompany.setNoOfEmployees(dto.getNoOfEmployees());

        Company updated = repository.save(oldCompany);
        return companyMapper.toDTO(updated);
    }

    @Override
    public void deleteCompany(Integer id) {
        if (!repository.existsById(id)) {
            throw new CompanyNotAvailableException("Cannot Delete! Company Not Found :: " + id);
        }
        repository.deleteById(id);
    }
}

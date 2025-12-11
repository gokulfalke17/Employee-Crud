package com.techpulse.mapper;

import com.techpulse.dto.CompanyRequestDTO;
import com.techpulse.dto.CompanyResponseDTO;
import com.techpulse.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(target = "companyId", ignore = true)
    Company toEntity(CompanyRequestDTO dto);

    @Mapping(target = "employees", ignore = true)
    CompanyResponseDTO toDTO(Company company);
}


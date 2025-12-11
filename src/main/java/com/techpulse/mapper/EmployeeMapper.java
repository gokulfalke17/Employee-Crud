package com.techpulse.mapper;

import com.techpulse.dto.EmployeeRequestDTO;
import com.techpulse.dto.EmployeeResponseDTO;
import com.techpulse.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "empId", ignore = true)
    Employee toEntity(EmployeeRequestDTO dto);

    @Mapping(target = "company", ignore = true)
    EmployeeResponseDTO toDTO(Employee employee);
}

package com.techpulse.mapper;

import com.techpulse.dto.EmployeeRequestDTO;
import com.techpulse.dto.EmployeeResponseDTO;
import com.techpulse.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    Employee toEntity(EmployeeRequestDTO dto);
    EmployeeResponseDTO toDTO(Employee employee);
}

package com.employee.EMS.mapper;

import org.springframework.stereotype.Component;

import com.employee.EMS.dto.EmployeeDTO;
import com.employee.EMS.model.Employee;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setDesignation(employee.getDesignation());
        dto.setDepartment(employee.getDepartment());
        dto.setAddress(employee.getAddress());
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setDesignation(dto.getDesignation());
        employee.setDesignation(dto.getDesignation());
        employee.setDepartment(dto.getDepartment());
        employee.setAddress(dto.getAddress());
        return employee;
    }

}
 
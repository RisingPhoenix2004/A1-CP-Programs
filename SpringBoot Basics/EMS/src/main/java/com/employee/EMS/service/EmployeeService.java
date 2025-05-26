package com.employee.EMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EMS.dto.EmployeeDTO;
import com.employee.EMS.model.Employee;
import com.employee.EMS.repository.EmployeeRepository;
import com.employee.EMS.mapper.EmployeeMapper;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // public Employee createEmployee(Employee employee){
    //     return employeeRepository.save(employee);
    // }
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    } 
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(
            ()->new RuntimeException("Employee Not Found with id : "+id)
        );
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee updatedEmployee){
        Employee employee = employeeRepository.findById(id).orElseThrow(
            ()->new RuntimeException("Employee Not Found with id : "+id)
        );

        //update fields if they are provided in the request
        if(updatedEmployee.getName() != null){
            employee.setName(updatedEmployee.getName());
        }
        if(updatedEmployee.getDesignation() != null){
            employee.setDesignation(updatedEmployee.getDesignation());
        }
        if(updatedEmployee.getDepartment() != null){
            employee.setDepartment(updatedEmployee.getDepartment());
        }
        if(updatedEmployee.getAddress() != null){
            employee.setAddress(updatedEmployee.getAddress());
        }
        
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id){
        if(!employeeRepository.existsById(id)){
            throw new RuntimeException("Employee not found with id : " + id);
        }
        employeeRepository.deleteById(id);
    }
}

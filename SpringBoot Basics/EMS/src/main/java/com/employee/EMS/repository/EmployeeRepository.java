package com.employee.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EMS.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    //Spring Data JPA provides CRUD methods automatically
}

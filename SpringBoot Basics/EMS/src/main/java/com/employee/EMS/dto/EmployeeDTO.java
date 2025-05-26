package com.employee.EMS.dto;

import jakarta.validation.constraints.NotBlank;


public class EmployeeDTO {
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotBlank(message = "department is mandatory")
    private String department;
    
    @NotBlank(message = "Address is mandatory")
    private String address;

    // Getters and Setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getDesignation(){return designation;}
    public void setDesignation(String designation){this.designation = designation;}
    public String getDepartment(){return department;}
    public void setDepartment(String department){this.department = department;}
    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}
} 
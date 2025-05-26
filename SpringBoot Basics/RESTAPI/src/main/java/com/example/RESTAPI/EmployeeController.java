package com.example.RESTAPI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/my-name")
    public String myName(){
        return "KMIT";
    }

    @PostMapping("/create")
    public String createEmployee(){
        return "Employee create testing";
    }

    @PutMapping("/update")
    public String updateEmployee(){
        return "Employee update testing";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(){
        return "Employee delete testing";
    }
}   

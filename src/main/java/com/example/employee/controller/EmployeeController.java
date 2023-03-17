package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class EmployeeController{
    
     @Autowired
    EmployeeJpaService employeeService;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employees")

    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId")int employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/employees/{employeeId}")

    public Employee updateEmployee(@PathVariable("employeeId") int employeeId,@RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId,employee);
    }

    @DeleteMapping("/employees/{employeeId}")

    public void deleteMappping(@PathVariable("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
    }



}
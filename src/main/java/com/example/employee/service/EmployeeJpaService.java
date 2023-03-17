

package com.example.employee.service;

import java.util.ArrayList;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class EmployeeJpaService implements EmployeeRepository{

    @Autowired
    EmployeeJpaRepository employeeJpaRepository;

	@Override
	public ArrayList<Employee> getEmployees() {
		List<Employee> employeesList = employeeJpaRepository.findAll();
		ArrayList<Employee> employees  = new ArrayList<>(employeesList);
		return employees;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		try{
			return employeeJpaRepository.findById(employeeId).get();
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employeeJpaRepository.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		
			Employee existingEmployee = getEmployeeById(employeeId);
			if(employee.getEmployeeName()!= null){
				existingEmployee.setEmployeeName(employee.getEmployeeName());
			}
			if(employee.getEmail() != null){
				existingEmployee.setEmail(employee.getEmail());
			}
			if(employee.getDepartment() != null){
				existingEmployee.setDepartment(employee.getDepartment());
			}
			employeeJpaRepository.save(existingEmployee);
			return existingEmployee;
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeJpaRepository.deleteById(employeeId);
		
	}


    





}
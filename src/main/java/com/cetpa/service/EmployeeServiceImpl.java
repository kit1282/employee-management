package com.cetpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public void addRecord(Employee employee) 
	{
		employeeRepository.addEmployee(employee);
	}

	public List<Employee> getList() 
	{
		return employeeRepository.getEmployeeList();
	}
	public Employee getRecord(int eid) 
	{
		return employeeRepository.getEmployee(eid);
	}
	public void deleteRecord(int eid) 
	{
		Employee employee=employeeRepository.getEmployee(eid);
		employeeRepository.deleteEmployee(employee);
	}
	public void updateRecord(Employee employeen) 
	{
		Employee employeeo=employeeRepository.getEmployee(employeen.getEid());
		employeeRepository.updateEmployee(employeeo,employeen);
	}
}

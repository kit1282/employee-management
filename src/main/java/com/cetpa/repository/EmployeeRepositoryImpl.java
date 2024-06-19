package com.cetpa.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction trasnaction;
	
	@Autowired
	public EmployeeRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		trasnaction=session.getTransaction();
	}

	public void addEmployee(Employee employee) 
	{
		trasnaction.begin();
		session.persist(employee);
		trasnaction.commit();
	}

	public List<Employee> getEmployeeList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		List<Employee> elist=query.list();
		return elist;
	}

	public Employee getEmployee(int eid) 
	{
		Employee emp=session.get(Employee.class,eid);
		return emp;
	}
	public void deleteEmployee(Employee employee) 
	{
		trasnaction.begin();
		session.delete(employee);
		trasnaction.commit();
	}
	public void updateEmployee(Employee employeeo, Employee employeen) 
	{
		trasnaction.begin();
		employeeo.setFirstname(employeen.getFirstname());
		employeeo.setLastname(employeen.getLastname());
		employeeo.setPhone(employeen.getPhone());
		employeeo.setDepartment(employeen.getDepartment());
		employeeo.setSalary(employeen.getSalary());
		trasnaction.commit();
	}
}

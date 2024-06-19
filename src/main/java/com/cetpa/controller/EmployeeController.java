package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.entity.Employee;
import com.cetpa.service.EmployeeService;

@Controller
@RequestMapping("employee-management")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("")
	public String getHomeView()
	{
		return "home";
	}
	@RequestMapping("add-employee")
	public String getAddEmployeeView()
	{
		return "add";
	}
	@RequestMapping("add-record")
	public String addEmployeeRecord(Employee employee)
	{
		employeeService.addRecord(employee);
		return "save-success";
	}
	@RequestMapping("employee-list")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist", employeeList);
		return "list";
	}
	@RequestMapping("search-employee")
	public String getSearchEmployeeView()
	{
		return "search";
	}
	@RequestMapping("search-record")
	public String showEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("eid",eid);
			model.addAttribute("msg","Record not found");
			return "search";
		}
		model.addAttribute("employee",employee);
		return "show";
	}
	@RequestMapping("delete-employee")
	public String getDeleteEmployeeView()
	{
		return "delete";
	}
	@RequestMapping("delete-record")
	public String getConfirmDeleteView(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("eid",eid);
			model.addAttribute("msg","Record does not exist");
			return "delete";
		}
		model.addAttribute("employee",employee);
		return "confirm-delete";
	}
	@RequestMapping("delete-employee-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteRecord(eid);
		return "delete-success";
	}
	@RequestMapping("edit-employee")
	public String getEditEmployeeView()
	{
		return "edit";
	}
	@RequestMapping("get-record")
	public String getEmployeeRecordView(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("eid",eid);
			model.addAttribute("msg","Record does not exist");
			return "edit";
		}
		model.addAttribute("employee",employee);
		return "show-record";
	}
	@RequestMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateRecord(employee);
		return "update-success";
	}
}

package com.masai.dao;

import java.util.List;

import com.masai.EmployeeException.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployee()throws EmployeeException;
	public String getAddressOfEmployee(int empId)throws EmployeeException;
	public String giveBonusToEmployee(int empId, int bonus)throws EmployeeException;
	public boolean deleteEmployee(int empId) throws EmployeeException;	
	public String[] getNameAndAddress(int empId)throws EmployeeException;
}

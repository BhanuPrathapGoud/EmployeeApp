package com.masai.user;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Employee;

public class SaveRecord {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee employee = new Employee(25,"chandu","Magalore",25000);
		employeeDao.save(employee);
	}
}

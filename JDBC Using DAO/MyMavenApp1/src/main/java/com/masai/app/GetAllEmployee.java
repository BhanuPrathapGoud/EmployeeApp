package com.masai.app;

import java.util.List;

import com.masai.EmployeeException.EmployeeException;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.model.Employee;

public class GetAllEmployee {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			List<Employee> list = employeeDAO.getAllEmployee();
			for(Employee e : list) {
				System.out.println(e);
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

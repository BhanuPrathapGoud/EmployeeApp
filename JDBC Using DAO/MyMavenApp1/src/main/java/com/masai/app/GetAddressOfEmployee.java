package com.masai.app;

import java.util.Scanner;

import com.masai.EmployeeException.EmployeeException;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;

public class GetAddressOfEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id");
		int empId = sc.nextInt();
		sc.close();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			String result = employeeDAO.getAddressOfEmployee(empId);
			System.out.println(result);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		
	}
}

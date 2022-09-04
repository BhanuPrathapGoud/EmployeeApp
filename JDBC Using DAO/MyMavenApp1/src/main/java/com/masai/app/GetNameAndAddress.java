package com.masai.app;

import java.util.Arrays;
import java.util.Scanner;

import com.masai.EmployeeException.EmployeeException;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;

public class GetNameAndAddress {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id");
		int empId = sc.nextInt();
		sc.close();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			String[] result = employeeDAO.getNameAndAddress(empId);
			System.out.println(Arrays.toString(result));
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
	}
}

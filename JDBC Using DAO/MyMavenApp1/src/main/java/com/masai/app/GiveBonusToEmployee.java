package com.masai.app;

import java.util.Scanner;

import com.masai.EmployeeException.EmployeeException;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;

public class GiveBonusToEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Id");
		int empId = sc.nextInt();
		System.out.println("Enter Employee Bonus");
		int bonus = sc.nextInt();
		sc.close();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			String result = employeeDAO.giveBonusToEmployee(empId, bonus);
			System.out.println(result);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

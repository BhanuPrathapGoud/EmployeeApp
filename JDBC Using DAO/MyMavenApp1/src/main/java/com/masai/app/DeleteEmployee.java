package com.masai.app;

import java.util.Scanner;

import com.masai.EmployeeException.EmployeeException;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;

public class DeleteEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int empId = sc.nextInt();
		sc.close();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			boolean result = employeeDAO.deleteEmployee(empId);
			if(result) {
				System.out.println("Employee record Deleted SucessFully !!!!");
			}else {
				System.out.println("Employee record Not Deleted  !!!!");
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

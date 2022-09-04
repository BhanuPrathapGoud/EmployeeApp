package com.masai.user;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class DeleteEmployee {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id = sc.nextInt();
		boolean result = employeeDao.deleteEmployee(id);
		if(result) System.out.println("Record removed Succesfully !");
		else System.out.println("Record Not removed .......");
	}
}

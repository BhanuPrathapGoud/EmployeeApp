package com.masai.user;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class GetAddress {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id = sc.nextInt();
		sc.close();
		String result = employeeDao.getAddressOfEmployee(id);
		System.out.println(result);
	}
}

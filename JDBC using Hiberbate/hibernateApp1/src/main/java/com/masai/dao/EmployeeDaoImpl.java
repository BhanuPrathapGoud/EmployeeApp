package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.entity.UtilDB;
import com.masai.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void save(Employee emp) {
		EntityManager em = UtilDB.entityProvider();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		System.out.println("done...");
		em.close();
	}

	@Override
	public String getAddressOfEmployee(int empId) {
		String result = "Data Not Found";
		EntityManager em = UtilDB.entityProvider();
		Employee s = em.find(Employee.class, empId);
		if(s!= null)
			result= s.getAddress();
		em.close();
		return result;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		String result = "Data Not Found";
		EntityManager em = UtilDB.entityProvider();
		Employee s = em.find(Employee.class, empId);
		
		em.getTransaction().begin();
		if(s!=null) {
			s.setSalary(bonus+s.getSalary());
			result = s.toString();
		}
		em.close();
		return result;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean result = false;
		EntityManager em = UtilDB.entityProvider();
		Employee employee = em.find(Employee.class, empId);
		if(employee != null) {
			em.getTransaction().begin();
			em.remove(employee);
			em.getTransaction().commit();
			result = true;
		}
		em.close();
		return result;
	}

}

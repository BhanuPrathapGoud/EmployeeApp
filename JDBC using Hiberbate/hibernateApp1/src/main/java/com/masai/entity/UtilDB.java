package com.masai.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilDB {
	public static EntityManager entityProvider() {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("EmployeeUnit");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}

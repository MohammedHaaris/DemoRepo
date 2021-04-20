package com.te.springmvc1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc1.bean.EmployeeBean;

@Repository
public class EmployeeInplementation implements EmployeDAO {

	@Override
	public EmployeeBean authenticate(int id, String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager entityManager = factory.createEntityManager();
		EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
		if (bean != null) {
			if (bean.getPassword().equals(password)) {
				System.out.println("login succes");
				return bean;
			} else {
				System.out.println("invalid credintial");
			}
		} else {
			System.out.println("user not found");
		}
		return null;
	}

	@Override
	public EmployeeBean getEmp(int id) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("springdb");
		EntityManager entityManager = factory.createEntityManager();
		 EmployeeBean bean=entityManager.find(EmployeeBean.class,id);
		return bean;
	}
//	

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}

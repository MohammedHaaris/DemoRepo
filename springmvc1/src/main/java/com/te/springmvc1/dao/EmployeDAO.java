package com.te.springmvc1.dao;

import java.util.List;

import com.te.springmvc1.bean.EmployeeBean;

public interface EmployeDAO {
	public EmployeeBean authenticate(int id, String password );
	 public EmployeeBean getEmp(int id); 
	 public boolean delete(int id);
	 public List<EmployeeBean> getAllEmp();
}

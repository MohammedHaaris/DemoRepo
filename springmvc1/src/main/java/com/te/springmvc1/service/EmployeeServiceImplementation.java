package com.te.springmvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc1.bean.EmployeeBean;
import com.te.springmvc1.dao.EmployeDAO;
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	EmployeDAO employee;

	@Override
	public EmployeeBean authenticate(int id, String password) {
		return employee.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmp(int id) {

		return employee.getEmp(id);
	}

	@Override
	public boolean delete(int id) {

		return employee.delete(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		return employee.getAllEmp();
	}

}

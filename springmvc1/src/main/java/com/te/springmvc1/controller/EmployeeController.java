package com.te.springmvc1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc1.bean.EmployeeBean;
import com.te.springmvc1.dao.EmployeDAO;
import com.te.springmvc1.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employe;
	

	@GetMapping("/emp")
	public String getLoginForm() {

		return "loginForm";

	}

	@PostMapping("/empLogin")
	public String authenticate(int id, String pwd, HttpServletRequest request, ModelMap map) {
		EmployeeBean bean = employe.authenticate(id, pwd);
		if (bean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", bean);
			return "hompage";
		} else {
			map.addAttribute("errmsg", "invalid credential");
			return "loginForm";
		}

	}

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "searchForm";
		} else {
			map.addAttribute("errmsg", "please login again");
			return "loginForm";

		}
		
	}
	@GetMapping("/empsearch")
	public String getEmpSearch(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			EmployeeBean bean = employe.getEmp(id);
			if (bean != null) {
				map.addAttribute("data", bean);
			} else {
				map.addAttribute("msg", "Data not found for id: " + id);
			}
			return "searchForm";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("errmsg", "Logout Sucessfully");
		return "login";
	}

	@GetMapping("/showDeletePage")
	public String getdeleteForm(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			return "delete";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "loginForm";
		}
	}
	@GetMapping("/deleteEmp")
	public String deleteEmp(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			Boolean dataBoolean = employe.delete(id);
			if (dataBoolean) {
				map.addAttribute("msg", "Deleted successfully");
			} else {
				map.addAttribute("msg", " Data not found ");
			}
			return "deleteForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of deleteEmp Method

	@GetMapping("/alldata")
	public String getAllEmpData(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			List<EmployeeBean> data = employe.getAllEmp();
			if (data != null) {
				map.addAttribute("data", data);
			} else {
				map.addAttribute("errmsg", "Empty Table");
			}
			return "showAll";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}

}

/**
 * 
 */
package com.codealpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.codealpha.entity.Employee;
import com.codealpha.entity.Role;
import com.codealpha.exception.EmployeeNotFoundException;
import com.codealpha.service.EmployeeService;

@SessionAttributes("id")
@Controller
public class LoginController {

	@Autowired
	public EmployeeService empService;

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@PostMapping("/adminlogin")
	public String adminLogin(@RequestParam String empId, @RequestParam String password, Model model) {

		try {
			boolean res = empService.isLoginSuccessful(Integer.parseInt(empId), password);
			if (res) {
				model.addAttribute("id", empId);

				Employee emp = empService.findEmployeeById(Integer.parseInt(empId));
				int flag = 0;

				for (Role role : emp.getRoles()) {
					if (role.getRoleName().equalsIgnoreCase("ADMIN")) {
						flag = 1;
						break;
					}
				}

				if (flag == 1) {
					List<Employee> employees = empService.getAllEmployee();
					model.addAttribute("employees", employees);
					return "employeelist";
				} else {
					model.addAttribute("employee", emp);
					return "employeeDetails";
				}

			}
		} catch (EmployeeNotFoundException e) {
			model.addAttribute("message", "Bad credentials");
		}
		return "login";
	}


	@GetMapping("/adminlogout")
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "login";
	}

}

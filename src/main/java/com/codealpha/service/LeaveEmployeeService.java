package com.codealpha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codealpha.entity.LeaveInfoEmployees;
import com.codealpha.repository.LeaveInfoEmployeesRepo;

@Service
public class LeaveEmployeeService {

	@Autowired
	private LeaveInfoEmployeesRepo repoEmpL;

	public void saveLeaveInfo(LeaveInfoEmployees obj) {
		repoEmpL.save(obj);
	}

	public List<LeaveInfoEmployees> getAllLeaves() {
		return (List<LeaveInfoEmployees>) repoEmpL.findAll();
	}

	public LeaveInfoEmployees getEmployeeLeaveDetails(int empId) {
		for (LeaveInfoEmployees obj : getAllLeaves()) {
			if (obj.getEmployeeId() == empId)
				return obj;
		}
		return null;
	}

}

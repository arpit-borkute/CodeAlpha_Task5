/**
 * 
 */
package com.codealpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codealpha.entity.LeaveInfoEmployees;

@Repository
public interface LeaveInfoEmployeesRepo extends JpaRepository<LeaveInfoEmployees, Integer> {

}

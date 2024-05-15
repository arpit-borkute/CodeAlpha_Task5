/**
 * 
 */
package com.codealpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codealpha.entity.Employee;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}

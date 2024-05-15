/**
 * 
 */
package com.codealpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codealpha.entity.LeaveInformation;

@Repository
public interface LeaveInformationRepo extends JpaRepository<LeaveInformation, Integer>{

}

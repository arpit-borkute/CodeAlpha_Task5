/**
 * 
 */
package com.codealpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codealpha.entity.ApplyLeave;

@Repository
public interface ApplyLeaveRepo extends JpaRepository<ApplyLeave, Integer> {

}

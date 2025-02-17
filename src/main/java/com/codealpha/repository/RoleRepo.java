package com.codealpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codealpha.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{

}

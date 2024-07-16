package com.edix.clinicaspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edix.clinicaspring.modelo.entitybeans.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role,Integer>{
	
	
	
}

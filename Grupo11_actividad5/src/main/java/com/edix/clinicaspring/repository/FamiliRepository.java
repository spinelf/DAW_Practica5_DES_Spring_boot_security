package com.edix.clinicaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edix.clinicaspring.modelo.entitybeans.Familia;

@Repository
public interface FamiliRepository extends JpaRepository <Familia,Integer>{

}

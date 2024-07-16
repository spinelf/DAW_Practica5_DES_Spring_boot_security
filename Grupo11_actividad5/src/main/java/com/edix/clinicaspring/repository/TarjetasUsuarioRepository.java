package com.edix.clinicaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edix.clinicaspring.modelo.entitybeans.TarjetasUsuario;

@Repository
public interface TarjetasUsuarioRepository extends JpaRepository <TarjetasUsuario,Integer>{

}

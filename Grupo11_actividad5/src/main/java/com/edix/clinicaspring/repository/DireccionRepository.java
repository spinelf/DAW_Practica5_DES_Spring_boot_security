package com.edix.clinicaspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;

@Repository
public interface DireccionRepository extends JpaRepository <Direccion,Integer> {
	
    @Query(nativeQuery = true, value = "select * from direcciones where cp=?")
	
				List<Direccion> findPorCP(String cp);
    
    @Query(nativeQuery = true, value = "SELECT d.* FROM direcciones d inner join direcciones_usuarios du on d.id_direccion=du.id_direccion \r\n"
    		+ "inner join usuarios u on u.id_usuario=du.id_usuario where u.id_usuario=?;")
    		List<Direccion> findByUsuario (int id_usuario);

}

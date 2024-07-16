package com.edix.clinicaspring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edix.clinicaspring.modelo.entitybeans.Producto;
import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository <Tarjeta,Integer> {
	
    @Query(nativeQuery = true, value = "SELECT t.* FROM tarjetas t inner join tarjetas_usuarios tu on t.id_tarjeta=tu.id_tarjeta \r\n"
    		+ "inner join usuarios u on u.id_usuario=tu.id_usuario where u.id_usuario=?;")
    		List<Tarjeta> findByUsuario (int id_usuario);
}

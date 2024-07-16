package com.edix.clinicaspring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edix.clinicaspring.modelo.entitybeans.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository <Pedido,Integer>{

	
	
	
}

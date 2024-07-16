package com.edix.clinicaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edix.clinicaspring.modelo.entitybeans.ProductosPedido;

@Repository
public interface ProductosPedidosRepository extends JpaRepository <ProductosPedido,Integer> {

}

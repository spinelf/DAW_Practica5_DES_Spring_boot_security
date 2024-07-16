package com.edix.clinicaspring.service;

import java.util.List;



import com.edix.clinicaspring.modelo.entitybeans.Producto;


public interface ProductoService {
	int altaProducto(Producto producto);
	int eliminarProducto (int idProducto);
	int editarProducto (Producto producto);
	Producto findById(int idProducto);
    List<Producto> findAll();
    List<Producto> findPorFamilia(int idFamilia);
    int mostrarPrecio (int idProducto);
    
}

package com.edix.clinicaspring.service;

import java.util.List;

import com.edix.clinicaspring.dtos.LineaPedidoDto;
import com.edix.clinicaspring.modelo.entitybeans.Producto;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;




public interface CarritoService {
	void crearCarrito();
	List<LineaPedidoDto> cogerLineas();
	boolean addProducto(Producto producto);
	boolean eliminarProducto(Producto producto);
	boolean realizarPedido(Usuario usuario);
	
	
}



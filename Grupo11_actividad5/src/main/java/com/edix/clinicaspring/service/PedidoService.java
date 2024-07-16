package com.edix.clinicaspring.service;

import java.util.Date;
import java.util.List;



import com.edix.clinicaspring.modelo.entitybeans.Pedido;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.dtos.LineaPedidoDto;


public interface PedidoService {
	int altaPedido(Usuario usuario, List<LineaPedidoDto> lineas);
	Pedido findById(int idPedido);
	List<Pedido> findAll();
	List<Pedido> findPorFecha(Date fecha);
	int salvarCarrito();
	
}

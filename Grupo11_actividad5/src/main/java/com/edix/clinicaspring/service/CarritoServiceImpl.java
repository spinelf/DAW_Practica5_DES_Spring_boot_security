package com.edix.clinicaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.clinicaspring.dtos.LineaPedidoDto;
import com.edix.clinicaspring.modelo.entitybeans.Producto;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;




@Service
public class CarritoServiceImpl implements CarritoService{
	
	@Autowired private PedidoService pedServer;

	@Override
	public void crearCarrito() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LineaPedidoDto> cogerLineas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProducto(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean realizarPedido(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
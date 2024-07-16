package com.edix.clinicaspring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Pedido;
import com.edix.clinicaspring.modelo.entitybeans.ProductosPedido;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.repository.PedidoRepository;


import com.edix.clinicaspring.dtos.LineaPedidoDto;


@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedrepo;

	@Override
	public int altaPedido (Usuario usuario, List<LineaPedidoDto> lineas) {
		List<ProductosPedido> productosPedido = new ArrayList<ProductosPedido>();
		Pedido pedido = new Pedido();
		pedido.setEstadoPedido("Terminado");
		pedido.setFechaPedido(new Date());
		pedido.setUsuario(usuario);
		
		
		for (LineaPedidoDto lc: lineas) {
			ProductosPedido linea = new ProductosPedido();
			linea.setCantidad(lc.getCantidad());
			linea.setPedido(pedido);
			
		}
		
		pedido.setProductosPedido(productosPedido);
		
		
		int filas = 0;
		try {
			pedrepo.save(pedido);
			filas = lineas.size() + 1;
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return filas;
	}


	@Override
	public Pedido findById(int idPedido) {
		return pedrepo.findById(idPedido).orElse(null);
	}
	
	@Override
	public List<Pedido> findAll(){
		return pedrepo.findAll();
	}

	@Override
	public int salvarCarrito() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Pedido> findPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

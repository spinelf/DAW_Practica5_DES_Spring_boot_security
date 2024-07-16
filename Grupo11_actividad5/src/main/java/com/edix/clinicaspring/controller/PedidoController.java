package com.edix.clinicaspring.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.clinicaspring.dtos.LineaPedidoDto;
import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Pedido;
import com.edix.clinicaspring.modelo.entitybeans.ProductosPedido;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.repository.ProductoRepository;
import com.edix.clinicaspring.service.PedidoService;

@Controller
@RequestMapping("/web/pedido")
public class PedidoController {
	
	@Autowired
	private ProductoRepository prepo;
	
	@PostMapping("/altapedido")
	public String comprar(HttpSession sesion) {
		
		List<LineaPedidoDto> lista = (List<LineaPedidoDto>)sesion.getAttribute("cesta");
		Pedido ped = new Pedido();
		ped.setDireccion((Direccion)sesion.getAttribute("direccion"));
		ped.setEstadoPedido("Terminado");
		ped.setFechaPedido(new Date());
		ped.setTarjeta(null);
		//ped.setUsuario(usuario);
		List<ProductosPedido> listaLP = new ArrayList<>();
		for (LineaPedidoDto ele: lista) {
			ProductosPedido pep = new ProductosPedido();
			pep.setCantidad(ele.getCantidad());
			pep.setPedido(ped);
			//pep.setProducto(prepo.findById(ele.getIdProducto()));
			pep.setPrecio(BigDecimal.valueOf(ele.getPrecioVenta()));
			
			listaLP.add(pep);
			
		}
	
		return "";
	
	}
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}

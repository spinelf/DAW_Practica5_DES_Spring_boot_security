package com.edix.clinicaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.clinicaspring.modelo.entitybeans.Producto;
import com.edix.clinicaspring.service.ProductoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("rest/producto")

public class ProductoRestController {

	@Autowired
	private ProductoService prodService;	
	
	  @GetMapping ("/precio/{id}")
		
	  public int precioProducto ( @PathVariable( "id" ) int idProducto ) {
	        return this.prodService.mostrarPrecio(idProducto);
	    }
	  
	  @GetMapping ("/productos/{id}")
		
	  public List<Producto> findPorFamilia ( @PathVariable( "id" ) int idFamilia ) {
		  	return this.prodService.findPorFamilia(idFamilia);
	    }
	
}

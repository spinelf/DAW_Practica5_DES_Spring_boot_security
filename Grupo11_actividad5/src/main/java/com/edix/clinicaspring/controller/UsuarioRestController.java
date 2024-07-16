package com.edix.clinicaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.service.UsuarioService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")

public class UsuarioRestController {
	

	@Autowired
		private UsuarioService userService;	
		
		  @GetMapping ("/cp")
			
		  public List<Usuario> usuarioPorCp(){
		        return this.userService.usuarioPorCp();
		    }
		  
}

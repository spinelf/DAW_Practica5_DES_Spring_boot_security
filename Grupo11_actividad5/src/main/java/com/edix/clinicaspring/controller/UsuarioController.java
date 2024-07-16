package com.edix.clinicaspring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Familia;
import com.edix.clinicaspring.modelo.entitybeans.Producto;
import com.edix.clinicaspring.modelo.entitybeans.Role;
import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.repository.TarjetaRepository;
import com.edix.clinicaspring.service.DireccionService;
import com.edix.clinicaspring.service.FamiliaService;
import com.edix.clinicaspring.service.ProductoService;
import com.edix.clinicaspring.service.RolService;
import com.edix.clinicaspring.service.TarjetaService;
import com.edix.clinicaspring.service.UsuarioService;



@RequestMapping("/user")
@Controller
public class UsuarioController {
	
	@Autowired
	ProductoService prodServ;
	@Autowired 
	private FamiliaService familiaServ;
	@Autowired
	private TarjetaService tarjetaServe;
	@Autowired
	private DireccionService direccionServe;
	@Autowired
	UsuarioService userServ;
	@Autowired
	RolService rolServ;
	@Autowired private PasswordEncoder passwordEncoder;

	// listados y detalles de apartados para el usuario
	
	//listado de productos
	
	@GetMapping("/productos")
	public String mostrarProductos(Model model) {
		List<Producto> producto = prodServ.findAll();
		model.addAttribute("listaProductos", producto);
		return "/comunes/listaProducto";
	}
	
	@GetMapping("/productosFamilia/{id}")
	public String mostrarProductosFamilia(Model model,@PathVariable(name="id") int  codigo) {
		List<Producto> producto = prodServ.findPorFamilia(codigo);
		model.addAttribute("listaProductos", producto);
		return "/comunes/listaProducto";
	}
	
	
	
	//detalle de producto
	
	@GetMapping("/verProducto/{id}")
	public String verUno(Model model, @PathVariable(name="id") int  codigo) {
		
		Producto producto = prodServ.findById(codigo);
		model.addAttribute("producto", producto);
		
		return "/comunes/detalleProducto";
		 		
	}
	
	@GetMapping("/buscarPorNombre/{nombre_producto}")
	public String productoXNombre() {
		
		return "productos";
	}
	
	@GetMapping("/familias")
	public String mostrarFamilias(Model model) {
		List<Familia> familia = familiaServ.findAll();
		model.addAttribute("listaFamilias", familia);
		return "/comunes/listaFamilias";
	}
	
	
	@GetMapping("/buscarPorFamilia/{idFamilia}")
	public String productosXFamilia() {
		
		return "productos";
	}

	//Faltan los método para añadir al carrito.

	
	//Usuario
	
	@GetMapping("/misDatos")
	public String mostrardatos(Authentication aut, Model model, HttpSession misesion) {
		
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = userServ.findByEmail(aut.getName());
        model.addAttribute("usuario", usuario);
        return "/usuario/misdatos";
    }
	@PostMapping("/misDatos")
	public String mostrardatos() {
		
		return "usuario";
	}

	@GetMapping("/editarUsuario/{id}")
	public String editarFamilia (Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = userServ.findById(codigo);
		model.addAttribute("usuario", usuario);
		return "/usuario/editar";
	}

		
	@PostMapping("/editarUsuario")
	public String editarUsuario(Usuario usuario, RedirectAttributes attr, Model model) {
		usuario.setEnabled(1);
		usuario.setRole(rolServ.findById(1));
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		if (userServ.editarUsuario(usuario) == 1) 
			model.addAttribute("mensajeExito", "Usuario editado correctamente");
		else 
			model.addAttribute("mensajeError", "No se ha podido editar el usuario");
		return "/comunes/mensaje";
	}
		
		
	//Tarjeta
	
	@GetMapping("/misTarjetas")
	public String findByUsuario (Authentication aut, Model model, HttpSession misesion) {
		
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = userServ.findByEmail(aut.getName());
		List<Tarjeta> tarjetas = tarjetaServe.findByUsuario(usuario.getIdUsuario());
		model.addAttribute("listaTarjetas", tarjetas);
        return "/usuario/detalleTarjeta";
    }
	
	@GetMapping("/altaTarjeta")
	public String altaTarjeta() {
		
		return "/usuario/altaTarjeta";
	}
	
	@PostMapping("/altaTarjeta")
	public String altaTarjeta(Tarjeta tarjeta,RedirectAttributes attr,Authentication aut, Model model) {
	
		Usuario usuario = userServ.findByEmail(aut.getName());	
		if (usuario.getTarjetas() == null) {			
			List<Tarjeta> tarjetasUsuario = new ArrayList<>();
		}		
		usuario.getTarjetas().add(tarjeta);		
		if (tarjetaServe.altaTarjeta(tarjeta) == 1) 			
			model.addAttribute("mensajeExito", "Tarjeta dada de alta correctamente");
		else 
			model.addAttribute("mensajeError", "No se ha podido realizar el alta de la tarjeta");
		return "/comunes/mensaje";
	}
	
	@PostMapping("/editarTarjeta")
	public String editarTarjeta() {
		
		return "/usuario/editarTarjeta";
	}
	
	//Dirección
	
	@GetMapping("/misDirecciones")
	public String DireccionByUsuario (Authentication aut, Model model, HttpSession misesion) {
	
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = userServ.findByEmail(aut.getName());
		List<Direccion> direccion = direccionServe.findByUsuario(usuario.getIdUsuario());
		model.addAttribute("listaDirecciones", direccion);
        return "/usuario/detalleDireccion";
    }
	
		@GetMapping("/altaDireccion")
		public String altaDireccion() {
			
			return "/usuario/altaDireccion";
		}
		@PostMapping("/altaDireccion")
		public String altaDireccion (Direccion direccion,RedirectAttributes attr,Authentication aut, Model model) {
			Usuario usuario = userServ.findByEmail(aut.getName());		
			if (usuario.getDirecciones() == null) {					
				List<Direccion> direccionesUsuario = new ArrayList<>();
			}	
			usuario.getDirecciones().add(direccion);		
			if (direccionServe.altaDireccion(direccion) == 1) 				
				model.addAttribute("mensajeExito", "Dirección dada de alta correctamente");			 	
			else 
				model.addAttribute("mensajeError", "No se ha podido realizar el alta de la dirección");
			return "/comunes/mensaje";
		}
		
		@InitBinder
	    public void initBinder(WebDataBinder webDataBinder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }
	
}

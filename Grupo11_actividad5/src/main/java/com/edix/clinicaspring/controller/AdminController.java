package com.edix.clinicaspring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.edix.clinicaspring.modelo.entitybeans.Familia;
import com.edix.clinicaspring.modelo.entitybeans.Role;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.modelo.entitybeans.Pedido;
import com.edix.clinicaspring.modelo.entitybeans.Producto;
import com.edix.clinicaspring.service.FamiliaService;
import com.edix.clinicaspring.service.PedidoService;
import com.edix.clinicaspring.service.ProductoService;
import com.edix.clinicaspring.service.RolService;
import com.edix.clinicaspring.service.UsuarioService;


@RequestMapping("/admin")
@Controller
public class AdminController {
	
	@Autowired private FamiliaService familiaServ;
	@Autowired private ProductoService productoServ;
	@Autowired private UsuarioService usuarioServ;
	@Autowired private RolService rolServ;
	@Autowired private PedidoService pedidoServ;
	@Autowired private PasswordEncoder passwordEncoder;

	
	//Listado de apartados y detalles
	
	//Usuarios
	

	@GetMapping("/usuarios")
	public String mostrarUsuarios(Model model) {
		List<Usuario> usuario = usuarioServ.findAll();
		model.addAttribute("listaUsuarios", usuario);
		return "/admin/listaUsuarios";
	}
	
	@GetMapping("/usuarios/{id}")
	public String detalleUsuario() {
		
		return "/admin/detalleUsuarios";
	}
	
	//Roles
	
	@GetMapping("/roles")
	public String mostrarRoles(Model model) {
		List<Role> rol = rolServ.findAll();
		model.addAttribute("listaRoles", rol);
		return "/admin/listaRoles";
	}
	
	@GetMapping("/roles/{id}")
	public String detalleRoles(Model model, @PathVariable(name="id") int codigo) {
		Role rol = rolServ.findById(codigo);
		model.addAttribute("rol", rol);
		return "/admin/detalleRoles";
	}
	
	//Pedidos
	
	@GetMapping("/pedidos")
	public String mostrarPedidos(Model model) {
		List<Pedido> pedido = pedidoServ.findAll();
		model.addAttribute("listaPedidos", pedido);
		return "/admin/listaPedidos";
	}
	
	@GetMapping("/pedidos/{id}")
	public String detallePedidos(Model model, @PathVariable(name="id") int codigo) {
		Pedido pedido = pedidoServ.findById(codigo);
		model.addAttribute("pedido", pedido);
		return "/admin/detallePedidos";
	}
	
			
	
	@GetMapping("/pedidosdia")
	public String buscarPorDia(Model model) {
		List<Pedido> pedido = pedidoServ.findAll();
		model.addAttribute("listaPedidodia", pedido);
		return "/admin/pedidosdia";
	}
	
	@GetMapping("/familias")
	public String mostrarFamilias(Model model) {
		List<Familia> familia = familiaServ.findAll();
		model.addAttribute("listaFamilias", familia);
		return "/comunes/listaFamilias";
	}
		
	// Editar e eliminar apartados
	
	@GetMapping("/editarFamilia/{id}")
	public String editarFamilia (Model model, @PathVariable(name="id") int  codigo) {
		Familia familia = familiaServ.findById(codigo);
		model.addAttribute("familia", familia);
		return "/admin/editarFamilias";
	}

		
	@PostMapping("/editarFamilia")
	public String editarFamilia(Familia familia, RedirectAttributes attr, Model model) {
		if (familiaServ.editarFamilia(familia) == 1) 
			model.addAttribute("mensajeExito", "Familia editada correctamente");
		else if (familiaServ.editarFamilia(familia) == 2) 
			model.addAttribute("mensaje", "familia no encontrada");
		else
			model.addAttribute("mensaje", "error al eliminar la familia");
		return "/comunes/mensaje";
	}
	
	@GetMapping("/editarRol/{id}")
	public String editarrRol (Model model, @PathVariable(name="id") int  codigo) {
		Role rol = rolServ.findById(codigo);
		model.addAttribute("rol", rol);
		return "forward:/admin/editarRol";
	}

	
	
	@PostMapping("/editarRol")
	public String editarRol(Role rol, RedirectAttributes attr) {
		if (rolServ.editarRol(rol) == 1) 
			attr.addFlashAttribute("mensajeExito", "Rol editado correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido editar el rol");
		return "redirect:/admin/detalleRoles";
	}
		
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario (Model model, @PathVariable(name="id") int  codigo) {
		Usuario usuario = usuarioServ.findById(codigo);
		model.addAttribute("usuario", usuario);
		return "forward:/admin/editarUsuario";
	}
	
	
	@PostMapping("/editarUsuario")
	public String editarUsuario(Usuario usuario, RedirectAttributes attr, Model model) {
		if (usuarioServ.editarUsuario(usuario) == 1) 
			model.addAttribute("mensajeExito", "Usuario editado correctamente");
		else 
			model.addAttribute("mensajeError", "No se ha podido editar el usuario");
		return "/comunes/mensaje";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editarProductos (Model model, @PathVariable(name="id") int  codigo) {
		Producto producto = productoServ.findById(codigo);
		model.addAttribute("producto", producto); 
		List<Familia> familia = familiaServ.findAll();
		model.addAttribute("listaFamilia", familia);
	    return "/admin/editarProducto";
			}	
	
	@PostMapping("/editarProducto")
	public String editarProducto(Producto producto, int idFamilia, RedirectAttributes attr, Model model) {
		
		Familia familia = familiaServ.findById(idFamilia);
		producto.setFamilia(familia);
		if (productoServ.altaProducto(producto) == 1) 	
			model.addAttribute("mensajeExito", "Producto editado correctamente");
		else 
			model.addAttribute("mensajeError", "No se ha podido editar el producto");		
		return "/comunes/mensaje";
	}
	
		
	//Dar de alta
	
	@GetMapping ("/altaFamilia")
	public String altaFamilia() {
	
		return "/admin/altaFamilia";
	}
	
	@PostMapping("/altaFamilia")
	public String altaFamilia(Familia familia, RedirectAttributes attr, Model model) {
		if (familiaServ.altaFamilia(familia) == 1) 
			model.addAttribute("mensajeExito", "Familia dada de alta correctamente");
		else 
			model.addAttribute("mensajeExito", "Familia dada de alta correctamente");
		return "/comunes/mensaje";
	}
				
	@GetMapping ("/altaRol")
	public String altaRol() {
	
		return "/admin/altaRol";
	}
	
	@PostMapping("/altaRol")
	public String altaRol(Role rol, RedirectAttributes attr) {
		if (rolServ.altaRol(rol) == 1) 
			
			attr.addFlashAttribute("mensajeExito", "Rol dado de alta correctamente");
		else 
			attr.addFlashAttribute("mensajeError", "No se ha podido realizar el alta del rol");
		
		return "forward:/admin/listaRoles";
	}
	
	
	
	@GetMapping("/altaUsuarioAdmin")
	public String registrar(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    return "/admin/altausuarioadmin";
	}
	
	@PostMapping("/altaUsuarioAdmin")
	public String registrarse(Usuario usuario, RedirectAttributes attr, Model model) {
		System.out.println(usuario);
		if (usuarioServ.findByEmail(usuario.getEmailUsuario()) != null) {
			model.addAttribute("mensajeError", "Nombre de usuario ya existe");
			return "/comunes/mensaje";
		}
	
		usuario.setEnabled(1);
		usuario.setRole(rolServ.findById(1));
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		
	
		if (usuarioServ.altaUsuario(usuario) == 1) {
			model.addAttribute("mensajeExito", "Registro completo con &eacute;xito");
			return "/comunes/mensaje";
		} else {
			model.addAttribute("mensajeError", "Error al procesar el alta");
			return "/comunes/mensaje";
		}

	}
	
	@GetMapping("/altaProducto")
	public String altaProducto (Model model) {
		 List<Familia> familia = familiaServ.findAll();
		 model.addAttribute("listaFamilia", familia);
	    return "/admin/altaProducto";
			}
	
	@PostMapping("/altaProducto")
	public String altaProducto (Producto producto,int idFamilia, RedirectAttributes attr, Model model) {
		
		Familia familia = familiaServ.findById(idFamilia);
		producto.setFamilia(familia);				
		if (productoServ.altaProducto(producto) == 1) 		
			model.addAttribute("mensajeExito", "Producto dado de alta correctamente");
		else 
			model.addAttribute("mensajeError", "No se ha podido realizar el alta del producto");	
		return "/comunes/mensaje";
	}
	
	//Dar de baja
	
			
	@GetMapping("/eliminarProducto/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  codigo) {
		
		if (productoServ.eliminarProducto(codigo) == 1)
			model.addAttribute("mensaje", "producto eliminado");
		else
			model.addAttribute("mensaje", "producto NOOO eliminado");
		

		return "forward:/";
		 
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario (Model model, @PathVariable(name="id") int  codigo) {	
		if (usuarioServ.eliminarUsuario(codigo) == 1)
			model.addAttribute("mensaje", "usuario eliminado");
		else
			model.addAttribute("mensaje", "usuario NO eliminado");
		
		return "forward:/admin/usuarios";	 
	}
	
	@GetMapping("/eliminarRol/{id}")
	public String eliminarRol (Model model, @PathVariable(name="id") int  codigo) {
		if (rolServ.eliminarRol(codigo) == 1)
			model.addAttribute("mensaje", "rol eliminado");
		else
			model.addAttribute("mensaje", "rol no eliminado");
		
		return "forward:/admin/roles";
	}
	@GetMapping("/eliminarFamilia/{id}")
	public String eliminarFamilia (Model model, @PathVariable(name="id") int  codigo) {
		if (familiaServ.eliminarFamilia(codigo) == 1)
			model.addAttribute("mensaje", "familia eliminado");
		else if (familiaServ.eliminarFamilia(codigo) == 2)
			model.addAttribute("mensaje", "familia no encontrada");
		else 
			model.addAttribute("mensaje", "error al eliminar la familia");
		
		return "forward:/user/familias";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	
	
}


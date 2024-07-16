package com.edix.clinicaspring.service;

import java.util.List;

import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;





public interface UsuarioService {
	int altaUsuario(Usuario usuario);
	int altaUsuarioadmin(Usuario usuario);
	int eliminarUsuario (int idUsuario);
	int editarUsuario (Usuario usuario);
	Usuario findById(int idUsuario);
	Usuario findByEmail (String email);
    List<Usuario> findAll();
    List<Usuario> usuarioPorCp();
    void asignarTarjeta(Tarjeta tarjeta);
	void asignarDireccion(Direccion direccion);
	int desvincularTarjeta(Tarjeta tarjeta);
	void desvincularDireccion(int idDireccion);
}

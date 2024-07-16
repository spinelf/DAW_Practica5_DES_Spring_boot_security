package com.edix.clinicaspring.service;

import java.util.List;



import com.edix.clinicaspring.modelo.entitybeans.Role;


public interface RolService {
	int altaRol(Role rol);
	int eliminarRol (int idRol);
	int editarRol (Role rol);
	Role findById(int idRol);
	List<Role> findAll();

}

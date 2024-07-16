package com.edix.clinicaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.clinicaspring.modelo.entitybeans.Role;
import com.edix.clinicaspring.repository.RoleRepository;


@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RoleRepository rolrepo;

	@Override
	public int altaRol(Role rol) {
        try {
            this.rolrepo.save(rol);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarRol(int idRol) {
        try {
            this.rolrepo.deleteById(idRol);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int editarRol(Role rol) {
		if (findById(rol.getIdRol()) == null) return 0;
		try {
			rolrepo.save(rol);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Role findById(int idRol) {
		return rolrepo.findById(idRol).orElse(null);
	}

	@Override
	public List<Role> findAll() {
		return this.rolrepo.findAll();
	}

	

	
}

package com.edix.clinicaspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository urepo;
	
	private List<Tarjeta> tarjetasUsuario;
	private List<Direccion> direccionesUsuario;
	

	@Override
	public int altaUsuario(Usuario usuario) {
        try {
            this.urepo.save(usuario);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarUsuario(int idUsuario) {
        try {
            this.urepo.deleteById(idUsuario);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
    }
	
		@Override
	public Usuario findById(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

	@Override
	public List<Usuario> findAll() {
		return this.urepo.findAll();
	}

	@Override
	public int editarUsuario(Usuario usuario) {
		try {
			urepo.save(usuario);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Usuario> usuarioPorCp() {
		return this.urepo.usuarioPorCp();
	}

	@Override
	public int altaUsuarioadmin(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario findByEmail(String email) {
		return urepo.findByEmail(email);
	}

	@Override
	public void asignarTarjeta(Tarjeta tarjeta) {
		if (tarjetasUsuario == null)
			tarjetasUsuario= new ArrayList();
		tarjetasUsuario.add(tarjeta);
		
	}

	@Override
	public void asignarDireccion(Direccion direccion) {
		if (direccionesUsuario == null)
			direccionesUsuario= new ArrayList();
		direccionesUsuario.add(direccion);
		
	}

	@Override
	public int desvincularTarjeta(Tarjeta tarjeta) {
		if (tarjetasUsuario == null)
			return 0;
		else
			tarjetasUsuario.remove(tarjeta);
			return 1;
	}

	@Override
	public void desvincularDireccion(int idDireccion) {
		// TODO Auto-generated method stub
		
	}

	
}

package com.edix.clinicaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;
import com.edix.clinicaspring.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	private DireccionRepository drepo;

	@Override
	public int altaDireccion(Direccion direccion) {
        try {
            this.drepo.save(direccion);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarDireccion(int idDireccion) {
        try {
            this.drepo.deleteById(idDireccion);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int editarDireccion(Direccion direccion) {
		if (findById(direccion.getIdDireccion()) == null) return 0;
		try {
			drepo.save(direccion);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Direccion findById(int idDireccion) {
		return drepo.findById(idDireccion).orElse(null);
	}

	@Override
	public List<Direccion> findAll() {
		return this.drepo.findAll();
	}

	@Override
	public List<Direccion> findPorCP(String cp) {
		return drepo.findPorCP(cp);
	}

	@Override
	public List<Direccion> findByUsuario(int id_usuario) {
		return drepo.findByUsuario(id_usuario);
	}

}

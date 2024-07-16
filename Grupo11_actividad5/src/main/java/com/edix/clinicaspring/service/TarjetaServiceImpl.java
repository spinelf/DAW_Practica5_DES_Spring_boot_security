package com.edix.clinicaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;
import com.edix.clinicaspring.repository.TarjetaRepository;
import com.edix.clinicaspring.repository.UsuarioRepository;

@Service
public class TarjetaServiceImpl implements TarjetaService {
	
	@Autowired
	private TarjetaRepository trepo;
	@Autowired
	private UsuarioRepository urepo;
	

	@Override
	public int altaTarjeta(Tarjeta tarjeta) {
        try {
            this.trepo.save(tarjeta);
            
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int eliminarTarjeta(int idTarjeta) {
        try {
            this.trepo.deleteById(idTarjeta);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int editarTarjeta(Tarjeta tarjeta) {
		if (findById(tarjeta.getIdTarjeta()) == null) return 0;
		try {
			trepo.save(tarjeta);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Tarjeta findById(int idTarjeta) {
		return trepo.findById(idTarjeta).orElse(null);
	}

	@Override
	public List<Tarjeta> findAll() {
		return this.trepo.findAll();
	}

	@Override
	public List<Tarjeta> findByUsuario(int id_usuario) {	
		return trepo.findByUsuario(id_usuario);
	}

	

}

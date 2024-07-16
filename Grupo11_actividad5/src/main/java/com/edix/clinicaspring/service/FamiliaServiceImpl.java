package com.edix.clinicaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.clinicaspring.modelo.entitybeans.Familia;
import com.edix.clinicaspring.repository.FamiliRepository;




@Service
public class FamiliaServiceImpl implements FamiliaService {
	
	@Autowired
	private FamiliRepository frepo;

	@Override
	public int altaFamilia (Familia familia) {
		int filas =0;
		try {
			frepo.save(familia);
			filas=1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarFamilia(int idFamilia) {
        try {
            this.frepo.deleteById(idFamilia);
            return 1;
        } catch (Exception e ) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public int editarFamilia(Familia familia) {
		
		try {
			frepo.save(familia);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Familia findById(int idFamilia) {
		return frepo.findById(idFamilia).orElse(null);
	}

	@Override
	public List<Familia> findAll() {
		return this.frepo.findAll();
	}

}

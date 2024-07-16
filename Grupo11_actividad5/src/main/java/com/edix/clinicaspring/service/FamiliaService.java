package com.edix.clinicaspring.service;

import java.util.List;



import com.edix.clinicaspring.modelo.entitybeans.Familia;


public interface FamiliaService {
	int altaFamilia(Familia familia);
	int eliminarFamilia (int idFamilia);
	int editarFamilia (Familia familia);
	Familia findById(int idFamilia);
    List<Familia> findAll();

}

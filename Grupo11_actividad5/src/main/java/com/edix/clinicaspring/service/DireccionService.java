package com.edix.clinicaspring.service;

import java.util.List;


import com.edix.clinicaspring.modelo.entitybeans.Direccion;
import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;


public interface DireccionService {
	int altaDireccion(Direccion direccion);
	int eliminarDireccion (int idDireccion);
	int editarDireccion (Direccion direccion);
	Direccion findById(int idDireccion);
    List<Direccion> findAll();
    List<Direccion> findPorCP(String cp);
    List<Direccion> findByUsuario (int id_usuario);

}

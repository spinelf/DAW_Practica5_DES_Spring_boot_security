package com.edix.clinicaspring.service;

import java.util.List;



import com.edix.clinicaspring.modelo.entitybeans.Tarjeta;
import com.edix.clinicaspring.modelo.entitybeans.Usuario;


public interface TarjetaService {
	int altaTarjeta(Tarjeta tarjeta);
	int eliminarTarjeta (int idTarjeta);
	int editarTarjeta (Tarjeta tarjeta);
	Tarjeta findById(int idTarjeta);
    List<Tarjeta> findAll();
    List<Tarjeta> findByUsuario (int id_usuario);

}

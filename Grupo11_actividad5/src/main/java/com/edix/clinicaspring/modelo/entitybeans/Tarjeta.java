package com.edix.clinicaspring.modelo.entitybeans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarjeta")
	private int idTarjeta;

	@Column(name="anno_caducidad")
	private String annoCaducidad;

	private String cvv;

	@Column(name="mes_caducidad")
	private String mesCaducidad;

	@Column(name="nombre_titular")
	private String nombreTitular;

	@Column(name="numero_tarjeta")
	private String numeroTarjeta;

	public Tarjeta() {
	}

	public Tarjeta(int idTarjeta, String annoCaducidad, String cvv, String mesCaducidad, String nombreTitular,
			String numeroTarjeta) {
		super();
		this.idTarjeta = idTarjeta;
		this.annoCaducidad = annoCaducidad;
		this.cvv = cvv;
		this.mesCaducidad = mesCaducidad;
		this.nombreTitular = nombreTitular;
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getAnnoCaducidad() {
		return this.annoCaducidad;
	}

	public void setAnnoCaducidad(String annoCaducidad) {
		this.annoCaducidad = annoCaducidad;
	}

	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getMesCaducidad() {
		return this.mesCaducidad;
	}

	public void setMesCaducidad(String mesCaducidad) {
		this.mesCaducidad = mesCaducidad;
	}

	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTarjeta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tarjeta))
			return false;
		Tarjeta other = (Tarjeta) obj;
		return idTarjeta == other.idTarjeta;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", annoCaducidad=" + annoCaducidad + ", cvv=" + cvv
				+ ", mesCaducidad=" + mesCaducidad + ", nombreTitular=" + nombreTitular + ", numeroTarjeta="
				+ numeroTarjeta + "]";
	}

}
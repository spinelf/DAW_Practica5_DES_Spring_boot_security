package com.edix.clinicaspring.modelo.entitybeans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the direcciones database table.
 * 
 */
@Entity
@Table(name="direcciones")
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direccion")
	private int idDireccion;

	private String calle;

	private String cp;

	private String letra;

	private String localidad;

	private int numero;

	private String piso;

	public Direccion() {
	}

	
	public Direccion(int idDireccion, String calle, String cp, String letra, String localidad, int numero,
			String piso) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.cp = cp;
		this.letra = letra;
		this.localidad = localidad;
		this.numero = numero;
		this.piso = piso;
	}


	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLetra() {
		return this.letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return this.piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idDireccion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Direccion))
			return false;
		Direccion other = (Direccion) obj;
		return idDireccion == other.idDireccion;
	}


	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", cp=" + cp + ", letra=" + letra
				+ ", localidad=" + localidad + ", numero=" + numero + ", piso=" + piso + "]";
	}

}
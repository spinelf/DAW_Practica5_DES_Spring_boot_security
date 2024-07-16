package com.edix.clinicaspring.modelo.entitybeans;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the direcciones_usuarios database table.
 * 
 */
@Entity
@Table(name="direcciones_usuarios")
@NamedQuery(name="DireccionesUsuario.findAll", query="SELECT d FROM DireccionesUsuario d")
public class DireccionesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direcciones_usuarios")
	private int idDireccionesUsuarios;

	//uni-directional many-to-one association to Direccione
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private Direccion direccion;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public DireccionesUsuario() {
	}
	
	

	public DireccionesUsuario(int idDireccionesUsuarios, Direccion direccion, Usuario usuario) {
		super();
		this.idDireccionesUsuarios = idDireccionesUsuarios;
		this.direccion = direccion;
		this.usuario = usuario;
	}



	public int getIdDireccionesUsuarios() {
		return this.idDireccionesUsuarios;
	}

	public void setIdDireccionesUsuarios(int idDireccionesUsuarios) {
		this.idDireccionesUsuarios = idDireccionesUsuarios;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DireccionesUsuario))
			return false;
		DireccionesUsuario other = (DireccionesUsuario) obj;
		return idDireccionesUsuarios == other.idDireccionesUsuarios;
	}



	@Override
	public String toString() {
		return "DireccionesUsuario [idDireccionesUsuarios=" + idDireccionesUsuarios + ", direccion=" + direccion
				+ ", usuario=" + usuario + "]";
	}

}
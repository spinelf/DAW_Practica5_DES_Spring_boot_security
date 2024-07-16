package com.edix.clinicaspring.modelo.entitybeans;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tarjetas_usuarios database table.
 * 
 */
@Entity
@Table(name="tarjetas_usuarios")
@NamedQuery(name="TarjetasUsuario.findAll", query="SELECT t FROM TarjetasUsuario t")
public class TarjetasUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarjetas_usuarios")
	private int idTarjetasUsuarios;

	//uni-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="id_tarjeta")
	private Tarjeta tarjeta;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public TarjetasUsuario() {
	}

	public TarjetasUsuario(int idTarjetasUsuarios, Tarjeta tarjeta, Usuario usuario) {
		super();
		this.idTarjetasUsuarios = idTarjetasUsuarios;
		this.tarjeta = tarjeta;
		this.usuario = usuario;
	}

	public int getIdTarjetasUsuarios() {
		return this.idTarjetasUsuarios;
	}

	public void setIdTarjetasUsuarios(int idTarjetasUsuarios) {
		this.idTarjetasUsuarios = idTarjetasUsuarios;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
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
		if (!(obj instanceof TarjetasUsuario))
			return false;
		TarjetasUsuario other = (TarjetasUsuario) obj;
		return idTarjetasUsuarios == other.idTarjetasUsuarios;
	}

	@Override
	public String toString() {
		return "TarjetasUsuario [idTarjetasUsuarios=" + idTarjetasUsuarios + ", tarjeta=" + tarjeta + ", usuario="
				+ usuario + "]";
	}

}
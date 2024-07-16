package com.edix.clinicaspring.modelo.entitybeans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;



/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="apellidos_usuario")
	private String apellidosUsuario;

	@Column(name="Password")
	private String password;

	@Column(name="email_usuario")
	private String emailUsuario;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="nombre_usuario")
	private String nombreUsuario;
		
	private int enabled;
		
	
	
	//uni-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Role role;
		
	//uni-directional many-to-many association to Direccion
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="direcciones_usuarios"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_direccion")
			}
		)
		private List<Direccion> direccionesUsuario;

	//uni-directional many-to-many association to Tarjeta
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="tarjetas_usuarios"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_tarjeta")
			}
		)
		private List<Tarjeta> tarjetasUsuario;


	public Usuario() {
	}

	public Usuario(int idUsuario, String apellidosUsuario, String password, String emailUsuario, Date fechaNacimiento,
			String nombreUsuario, int enabled,Role role) {
		super();
		this.idUsuario = idUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.password = password;
		this.emailUsuario = emailUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreUsuario = nombreUsuario;
		this.enabled = enabled;
		this.role = role;
		
	}
	public Usuario( String apellidosUsuario, String password, String emailUsuario, Date fechaNacimiento,
			String nombreUsuario, int enabled,Role role) {
		super();
		this.apellidosUsuario = apellidosUsuario;
		this.password = password;
		this.emailUsuario = emailUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreUsuario = nombreUsuario;
		this.enabled = enabled;
		this.role = role;
		
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidosUsuario() {
		return this.apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
		
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Direccion> getDirecciones() {
		return this.direccionesUsuario;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direccionesUsuario = direcciones;
	}

	public List<Tarjeta> getTarjetas() {
		return this.tarjetasUsuario;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetasUsuario = tarjetas;
	}
	
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellidosUsuario=" + apellidosUsuario + ", password=" + password
				+ ", emailUsuario=" + emailUsuario + ", fechaNacimiento=" + fechaNacimiento + ", nombreUsuario="
				+ nombreUsuario + ", enabled=" + enabled + ", role=" + role + ", direcciones=" + direccionesUsuario
				+ ", tarjetas=" + tarjetasUsuario + "]";
	}

	

	

	

}
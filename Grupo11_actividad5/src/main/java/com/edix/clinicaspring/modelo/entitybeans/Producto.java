package com.edix.clinicaspring.modelo.entitybeans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;

	@Column(name="descripcion_producto")
	private String descripcionProducto;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precio_producto")
	private double precioProducto;

	@Column(name="stock_producto")
	private int stockProducto;

	//uni-directional many-to-one association to Familia
	@ManyToOne
	@JoinColumn(name="id_familia")
	private Familia familia;

	public Producto() {
	}

	public Producto(int idProducto, String descripcionProducto, String nombreProducto, double precioProducto,
		int stockProducto, Familia familia) {
		super();
		this.idProducto = idProducto;
		this.descripcionProducto = descripcionProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.stockProducto = stockProducto;
		this.familia = familia;
	}

	public Producto(String descripcionProducto, String nombreProducto, double precioProducto,
			int stockProducto, Familia familia) {
			super();
			this.descripcionProducto = descripcionProducto;
			this.nombreProducto = nombreProducto;
			this.precioProducto = precioProducto;
			this.stockProducto = stockProducto;
			this.familia = familia;
		}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getStockProducto() {
		return this.stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcionProducto=" + descripcionProducto
				+ ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", stockProducto="
				+ stockProducto + ", familia=" + familia + "]";
	}

}
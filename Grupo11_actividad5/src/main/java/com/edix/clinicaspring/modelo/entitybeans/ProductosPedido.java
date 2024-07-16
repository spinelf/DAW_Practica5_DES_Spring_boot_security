package com.edix.clinicaspring.modelo.entitybeans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the productos_pedidos database table.
 * 
 */
@Entity
@Table(name="productos_pedidos")
@NamedQuery(name="ProductosPedido.findAll", query="SELECT p FROM ProductosPedido p")
public class ProductosPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_productos_pedidos")
	private int idProductosPedidos;

	//uni-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	//uni-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	private int cantidad;

	@JoinColumn(name="precio_venta")
	private BigDecimal precio;

	public ProductosPedido() {
	}

	public ProductosPedido(int idProductosPedidos, Pedido pedido, Producto producto, int cantidad, BigDecimal precio) {
		super();
		this.idProductosPedidos = idProductosPedidos;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public int getIdProductosPedidos() {
		return idProductosPedidos;
	}

	public void setIdProductosPedidos(int idProductosPedidos) {
		this.idProductosPedidos = idProductosPedidos;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProductosPedido))
			return false;
		ProductosPedido other = (ProductosPedido) obj;
		return idProductosPedidos == other.idProductosPedidos;
	}

}
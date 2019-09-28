package com.vot.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcategoria;

	

	@Column(nullable=false, length=50)
	private String nombrecategoria;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos;

	public Categoria() {
	}



	public String getNombrecategoria() {
		return this.nombrecategoria;
	}

	public void setNombrecategoria(String nombrecategoria) {
		this.nombrecategoria = nombrecategoria;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setCategoria(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setCategoria(null);

		return producto;
	}

	@Override
	public String toString() {
		return "Categoria [idcategoria=" + idcategoria + ", nombrecategoria=" + nombrecategoria + ", productos="
				+ productos + "]";
	}

	public Categoria(String nombrecategoria, List<Producto> productos) {
		super();
		this.nombrecategoria = nombrecategoria;
		this.productos = productos;
	}
	
	
	public Categoria(int idcategoria, List<Producto> productos) {
		super();
		this.idcategoria = idcategoria;
		this.productos = productos;
	}
	
	
	
	
	public int getIdcategoria() {
		return idcategoria;
	}



	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

}
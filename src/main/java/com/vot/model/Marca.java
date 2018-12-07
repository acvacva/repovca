package com.vot.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marcas database table.
 * 
 */
@Entity
@Table(name="marcas")
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idmarca;

	

	@Column(nullable=false, length=50)
	private String nombremarca;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="marca")
	private List<Producto> productos;

	public Marca() {
	}

	public Integer getIdmarca() {
		return idmarca;
	}



	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public String getNombremarca() {
		return this.nombremarca;
	}

	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setMarca(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setMarca(null);

		return producto;
	}

	@Override
	public String toString() {
		return "Marca [idmarca=" + idmarca + ", nombremarca=" + nombremarca + ", productos=" + productos + "]";
	}

	public Marca(String nombremarca, List<Producto> productos) {
		
		this.nombremarca = nombremarca;
		this.productos = productos;
	}

	
	
	

}
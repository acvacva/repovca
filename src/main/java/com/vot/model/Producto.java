package com.vot.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idproducto;

		

	@Column(nullable=false, length=50)
	private String nombreproducto;

	//bi-directional many-to-one association to Categoria
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idcategoria", nullable=false)
	private Categoria categoria;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="idmarca", nullable=false)
	private Marca marca;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="producto")
	private List<Comentario> comentarios;
	
	
	

	

	public Producto() {
	}

	public Integer getIdproducto() {
		return idproducto;
	}



	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombreproducto() {
		return this.nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setProducto(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setProducto(null);

		return comentario;
	}

	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", nombreproducto=" + nombreproducto + ", categoria=" + categoria
				+ ", marca=" + marca + ", comentarios=" + comentarios + "]";
	}

	public Producto(String nombreproducto, Categoria categoria, Marca marca, List<Comentario> comentarios) {
		
		this.nombreproducto = nombreproducto;
		this.categoria = categoria;
		this.marca = marca;
		this.comentarios = comentarios;
	}
	
	

}
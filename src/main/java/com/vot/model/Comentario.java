package com.vot.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the comentarios database table.
 * 
 */
@Entity
@Table(name="comentarios")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idcomentario;

	@Column(nullable=false)
	private int compraragain;

	@Column(nullable=false, length=500)
	private String descripcion;

	@Column(nullable=false)
	private Timestamp fecha;

	@Column(nullable=false)
	private int raiting;

	//bi-directional many-to-one association to Producto
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idproducto", nullable=false)
	private Producto producto;
	
	
	


	

	public Comentario() {
	}

	public Integer getIdcomentario() {
		return this.idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}

	public int getCompraragain() {
		return this.compraragain;
	}

	public void setCompraragain(int compraragain) {
		this.compraragain = compraragain;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getRaiting() {
		return this.raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	

	public Comentario(int compraragain, String descripcion, Timestamp fecha, int raiting, Producto producto
			) {
	
		this.compraragain = compraragain;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.raiting = raiting;
		this.producto = producto;
		
	}

	@Override
	public String toString() {
		return "Comentario [idcomentario=" + idcomentario + ", compraragain=" + compraragain + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", raiting=" + raiting + ", producto=" + producto + "]";
	}

	
	
	

}
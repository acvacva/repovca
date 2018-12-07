package com.vot.bean;

public class BeanFormProducto {
	private String nombreproducto;
	public String getNombreproducto() {
		return nombreproducto;
	}
	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	private String marca;
	private String categoria;
	
	
	@Override
	public String toString() {
		return "BeanFormProducto [nombreproducto=" + nombreproducto + ", marca=" + marca + ", categoria=" + categoria
				+ "]";
	}
	
	
	
	
}

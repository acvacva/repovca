package com.vot.repository;

public class ListMasComentados {
	
	private String id;
	private Long   total;
	
	public ListMasComentados(String id, Long total) {
		super();
		this.id = id;
		this.total = total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
}

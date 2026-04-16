package com.trips.models;

public class Categoria {
	
	private Integer id;
	private String nomCategoria;
	private String descripcion; // <-- Corregido aquí
	private boolean activo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomCategoria() {
		return nomCategoria;
	}
	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}
	public String getDescripcion() { // <-- Corregido aquí
		return descripcion;
	}
	public void setDescripcion(String descripcion) { // <-- Corregido aquí
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}

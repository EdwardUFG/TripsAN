package com.trips.models;

import java.util.Date;

public class Trip {
	
	private Integer id;
	private String nombre; // <-- Cambiado de nomTrip a nombre
	private String descripcion; // <-- Corregido el dedazo
	private double costo;
	private int calificacion;
	private String imagen;
	private String detalles;
	private boolean activo;
	private Date fecha;
	private Integer idCategoria;
	
	// Requerimiento de Diapositiva 24:
	private Integer destacado; // 1 para sí, 0 para no
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() { // <-- Actualizado
		return nombre;
	}
	public void setNombre(String nombre) { // <-- Actualizado
		this.nombre = nombre;
	}
	public String getDescripcion() { // <-- Actualizado
		return descripcion;
	}
	public void setDescripcion(String descripcion) { // <-- Actualizado
		this.descripcion = descripcion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	// Getters y Setters de la propiedad Destacado (Diapositiva 24)
	public Integer getDestacado() {
		return destacado;
	}
	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}

}
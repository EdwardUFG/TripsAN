package com.trips.models;

public class Categoria {
    
    private Integer id;
    private String nomCategoria;
    private String descripcion;
    private boolean activo;


    public Categoria() {}

    
    public Categoria(Integer id, String nomCategoria, String descripcion, boolean activo) {
        this.id = id;
        this.nomCategoria = nomCategoria;
        this.descripcion = descripcion;
        this.activo = activo;
    }

  
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNomCategoria() { return nomCategoria; }
    public void setNomCategoria(String nomCategoria) { this.nomCategoria = nomCategoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }


    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nomCategoria=" + nomCategoria +
               ", descripcion=" + descripcion + ", activo=" + activo + "]";
    }
}

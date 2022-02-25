package com.example.demo.models;


import javax.persistence.*;
@Entity
@Table(name="ciudad")
public class CiudadModel  {
   @EmbeddedId	
   private CiudadId ciudadId;
	
	private String descripcion;
	private String activo;
	
	public CiudadModel() {
    }

    public CiudadModel(CiudadId ciudadId, String descripcion, String activo) {
       super();
    	this.ciudadId = ciudadId;
        this.descripcion = descripcion;
        this.activo = activo;
    }
	public String getActivo() {
		return activo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}

	public CiudadId getCiudadId() {
		return ciudadId;
	}

	public void setCiudadId(CiudadId ciudadId) {
		this.ciudadId = ciudadId;
	}

	

	

}
package com.example.demo.models;

import javax.persistence.*;
@Entity
@Table(name="pais")
public class PaisModel {
	@Id
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String descripcion;
	private String activo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	

}
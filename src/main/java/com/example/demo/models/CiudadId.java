package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class CiudadId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPais;
	private Long id;

	public CiudadId() {
		
	}

	public CiudadId(Long idPais, Long id) {
		super();
		this.idPais = idPais;
		this.id = id;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idPais == null) ? 0 : idPais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CiudadId other = (CiudadId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idPais == null) {
			if (other.idPais != null)
				return false;
		} else if (!idPais.equals(other.idPais))
			return false;
		return true;
	}
}

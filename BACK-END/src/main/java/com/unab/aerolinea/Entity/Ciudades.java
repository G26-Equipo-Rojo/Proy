package com.unab.aerolinea.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ciudades")
public class Ciudades implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo_dane", length = 30, nullable = false, unique = true)
	private int codigo_dane;
	
	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo_dane() {
		return codigo_dane;
	}

	public void setCodigo_dane(int codigo_dane) {
		this.codigo_dane = codigo_dane;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

package com.unab.aerolinea.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "aeropuertos")
public class Aeropuertos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "cantidad_pista", length = 10, nullable = false)
	private int cantidad_pista;
	
	@Column(name = "cantidad_sala", length = 10, nullable = false)
	private int cantidad_sala;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Ciudades idCiudad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad_pista() {
		return cantidad_pista;
	}

	public void setCantidad_pista(int cantidad_pista) {
		this.cantidad_pista = cantidad_pista;
	}

	public int getCantidad_sala() {
		return cantidad_sala;
	}

	public void setCantidad_sala(int cantidad_sala) {
		this.cantidad_sala = cantidad_sala;
	}

	public Ciudades getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Ciudades idCiudad) {
		this.idCiudad = idCiudad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

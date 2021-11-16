package com.unab.aerolinea.Entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pasajeros")
public class Pasajeros implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_personas", nullable = false, unique = true)
	private Personas idPersonas;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_vuelos", nullable = false, unique = true)
	private Vuelos idVuelos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personas getIdPersonas() {
		return idPersonas;
	}

	public void setIdPersonas(Personas idPersonas) {
		this.idPersonas = idPersonas;
	}

	public Vuelos getIdVuelos() {
		return idVuelos;
	}

	public void setIdVuelos(Vuelos idVuelos) {
		this.idVuelos = idVuelos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

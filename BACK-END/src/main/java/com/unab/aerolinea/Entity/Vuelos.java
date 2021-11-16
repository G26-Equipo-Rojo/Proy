package com.unab.aerolinea.Entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "vuelos")
public class Vuelos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "hora_salida", length = 8, nullable = false)
	private int hora_salida;
	
	@Column(name = "hora_llegada", length = 8, nullable = false)
	private int hora_llegada;
	
	@Column(name = "fecha_salida", length = 10, nullable = false)
	private Date fecha_salida;
	
	@Column(name = "fecha_llegada", length = 10, nullable = false)
	private Date fecha_llegada;
	
	@Column(name = "cantidad_pasajeros", length = 8, nullable = false)
	private int cantidad_pasajeros;
		
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_aeropuerto_salida", nullable = false)
	private Aeropuertos idAeropuerto_Salida;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_aeropuerto_llegada", nullable = false)
	private Aeropuertos idAeropuerto_llegada;
		
	public Aeropuertos getIdAeropuerto_llegada() {
		return idAeropuerto_llegada;
	}

	public void setIdAeropuerto_llegada(Aeropuertos idAeropuerto_llegada) {
		this.idAeropuerto_llegada = idAeropuerto_llegada;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_avion", nullable = false)
	private Aviones idAvion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(int hora_salida) {
		this.hora_salida = hora_salida;
	}

	public int getHora_llegada() {
		return hora_llegada;
	}

	public void setHora_llegada(int hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Date getFecha_llegada() {
		return fecha_llegada;
	}

	public void setFecha_llegada(Date fecha_llegada) {
		this.fecha_llegada = fecha_llegada;
	}

	public int getCantidad_pasajeros() {
		return cantidad_pasajeros;
	}

	public void setCantidad_pasajeros(int cantidad_pasajeros) {
		this.cantidad_pasajeros = cantidad_pasajeros;
	}

	public Aeropuertos getIdAeropuerto_Salida() {
		return idAeropuerto_Salida;
	}

	public void setIdAeropuerto_Salida(Aeropuertos idAeropuerto_Salida) {
		this.idAeropuerto_Salida = idAeropuerto_Salida;
	}

	
	public Aviones getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Aviones idAvion) {
		this.idAvion = idAvion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

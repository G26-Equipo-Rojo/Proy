package com.unab.aerolinea.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aviones")
public class Aviones implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 10, nullable = false)
	private int codigo;
	
	@Column(name = "cantidad_pasajeros", length = 10, nullable = false)
	private int cantidad_pasajeros;
	
	@Column(name = "fabricante", length = 30, nullable = false)
	private String fabricante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad_pasajeros() {
		return cantidad_pasajeros;
	}

	public void setCantidad_pasajeros(int cantidad_pasajeros) {
		this.cantidad_pasajeros = cantidad_pasajeros;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

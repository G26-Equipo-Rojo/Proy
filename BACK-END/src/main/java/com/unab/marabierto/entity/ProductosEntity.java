package com.unab.marabierto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductosEntity {

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 12, nullable = false)
	private String codigo;
	
	@Column(name = "nombre", length = 65, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 65, nullable = false)
	private String descripcion;
		
	@Column(name = "categoria", length = 30, nullable = false)
	private String categoria;
		
	@Column(name = "nrolote", length = 20, nullable = false)
	private String nrolote;
	
	@Column(name = "prccompra", length = 12, nullable = false)
	private String prccompra;
		
	@Column(name = "prcventa", length = 12, nullable = false)
	private String prcventa;
		
	@Column(name = "cantidad", length = 12, nullable = false)
	private String cantidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNrolote() {
		return nrolote;
	}

	public void setNrolote(String nrolote) {
		this.nrolote = nrolote;
	}

	public String getPrccompra() {
		return prccompra;
	}

	public void setPrccompra(String prccompra) {
		this.prccompra = prccompra;
	}

	public String getPrcventa() {
		return prcventa;
	}

	public void setPrcventa(String prcventa) {
		this.prcventa = prcventa;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

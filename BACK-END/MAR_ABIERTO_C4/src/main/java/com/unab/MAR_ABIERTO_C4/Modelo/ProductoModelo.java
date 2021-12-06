package com.unab.MAR_ABIERTO_C4.Modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document("productos")
@Getter
@Setter
public class ProductoModelo {
	
	@Id
	private String id;
	
	@Field("nombre")
	private String nombre;
	
	@Field("descripcion")
	private String descripcion;
	
	@Field("precio_venta")
	private float precio_venta;
	
	@Field("precio_compra")
	private float precio_compra;
	
	@Field("num_lote")
	private String num_lote;
	
	@Field("cantidad")
	private int cantidad;
	
	@Field("vencimiento")
	private String vencimiento;
	
	@Field("origen")
	private String origen;
	
	@DBRef
	private CategoriaModelo categoria;
}

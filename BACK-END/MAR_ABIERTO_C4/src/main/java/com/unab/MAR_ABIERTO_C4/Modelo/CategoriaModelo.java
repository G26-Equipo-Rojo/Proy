package com.unab.MAR_ABIERTO_C4.Modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document("categorias")
@Getter
@Setter
public class CategoriaModelo {
	
	@Id
	private String id;
	
	@Field("codigo")
	private String codigo;
	
	@Field("nombre")
	private String nombre;
	
	@Field("descripcion")
	private String descripcion;
	
	@Field("fecha")
	private String fecha;

}

package com.unab.MAR_ABIERTO_C4.Modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document("usuarios")
@Getter
@Setter
public class UsuarioModelo {
	
	@Id
	private String id;
	
	@Field("nombre")
	private String nombre;
	
	@Field("apellido")
	private String apellido;
	
	@Field("correo")
	private String correo;
	
	@Field("documento")
	private String documento;
	
	@Field("telefono")
	private String telefono;
	
	@Field("rol")
	private String rol;
	
}

package com.com.mar_abierto.service;

import java.util.List;
import java.util.Optional;

import com.com.mar_abierto.entity.UsuarioEntity;

public interface IUsuarioService {
	
	//Listar todo
	public List<UsuarioEntity> all();
	
	//Listar por ID
	public Optional<UsuarioEntity> findById(Long id);
	
	//Guardar-Actualizar
	public UsuarioEntity save(UsuarioEntity usuarioEntity);
	
	//Eliminar por ID
	public void deleteById(Long id);

}

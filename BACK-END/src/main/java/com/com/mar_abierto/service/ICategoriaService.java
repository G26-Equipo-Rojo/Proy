package com.com.mar_abierto.service;

import java.util.List;
import java.util.Optional;

import com.com.mar_abierto.entity.CategoriaEntity;

public interface ICategoriaService {
	
	//Listar todos
	public List<CategoriaEntity> all();
	
	//Listar por ID
	public Optional<CategoriaEntity> findById(Long id);
	
	//Guardar-actualizar
	public CategoriaEntity save(CategoriaEntity inventarioEntity);	

	//Eliminar por ID
	public void deleteById(Long id);
	
}

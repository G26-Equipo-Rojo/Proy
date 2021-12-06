package com.unab.MAR_ABIERTO_C4.Service;

import java.util.List;
import java.util.Optional;

import com.unab.MAR_ABIERTO_C4.Modelo.CategoriaModelo;


public interface ICategoriaService {
	
	//Listar todos
	public List<CategoriaModelo> all();
	
	//Listar por ID
	public Optional<CategoriaModelo> findById(String id);
	
	//Guardar-actualizar
	public CategoriaModelo save(CategoriaModelo categoriaModelo);	

	//Eliminar por ID
	public void deleteById(String id);
}

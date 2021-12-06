package com.unab.MAR_ABIERTO_C4.Service;

import java.util.List;
import java.util.Optional;

import com.unab.MAR_ABIERTO_C4.Modelo.UsuarioModelo;

public interface IUsuarioService {
	//Listar todos
	public List<UsuarioModelo> all();
	
	//Listar por ID
	public Optional<UsuarioModelo> findById(String id);
	
	//Guardar-actualizar
	public UsuarioModelo save(UsuarioModelo usuarioModelo);	

	//Eliminar por ID
	public void deleteById(String id);
}

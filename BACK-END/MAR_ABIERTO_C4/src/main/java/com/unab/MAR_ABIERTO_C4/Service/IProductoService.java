package com.unab.MAR_ABIERTO_C4.Service;

import java.util.List;
import java.util.Optional;

import com.unab.MAR_ABIERTO_C4.Modelo.ProductoModelo;

public interface IProductoService {
	//Listar todos
	public List<ProductoModelo> all();
	
	//Listar por ID
	public Optional<ProductoModelo> findById(String id);
	
	//Guardar-actualizar
	public ProductoModelo save(ProductoModelo productoModelo);	

	//Eliminar por ID
	public void deleteById(String id);
}

package com.unab.marabierto.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.unab.marabierto.entity.ProductosEntity;
import com.unab.marabierto.service.IProductosService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/producto")

public class ProductosController {

	@Autowired
	private IProductosService service;
	
	@GetMapping
	public List<ProductosEntity> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<ProductosEntity> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductosEntity save(@RequestBody ProductosEntity productosEntity) {
		return service.save(productosEntity);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductosEntity update(@PathVariable Long id, @RequestBody ProductosEntity productosEntity) {
		Optional<ProductosEntity> op = service.findById(id);
		
		if (!op.isEmpty()) {
			ProductosEntity productosEntityUpdate = op.get();
			productosEntityUpdate.setCodigo(productosEntity.getCodigo());
			productosEntityUpdate.setNombre(productosEntity.getNombre());
			productosEntityUpdate.setDescripcion(productosEntity.getDescripcion());
			productosEntityUpdate.setCategoria(productosEntity.getCategoria());
			productosEntityUpdate.setNrolote(productosEntity.getNrolote());
			productosEntityUpdate.setPrccompra(productosEntity.getPrccompra());
			productosEntityUpdate.setPrcventa(productosEntity.getPrcventa());
			productosEntityUpdate.setCantidad(productosEntity.getCantidad());
			return service.save(productosEntityUpdate);
		}
		
		return productosEntity;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	
	
}

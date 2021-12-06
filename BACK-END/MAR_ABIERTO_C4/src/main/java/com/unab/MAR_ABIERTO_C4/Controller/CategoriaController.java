package com.unab.MAR_ABIERTO_C4.Controller;

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

import com.unab.MAR_ABIERTO_C4.Modelo.CategoriaModelo;
import com.unab.MAR_ABIERTO_C4.Service.ICategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
	
	
	@Autowired
	private ICategoriaService service;
	
	//CONSULTAR TODO
	@GetMapping
	public List<CategoriaModelo> all(){
		return this.service.all();
	}
	
	//CONSULTAR POR {ID}
	@GetMapping("{id}")
	public Optional<CategoriaModelo> show(@PathVariable String id){
		return this.service.findById(id);
	}
	
	//CREAMOS-INSERTAMOS
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CategoriaModelo save(@RequestBody CategoriaModelo categoriaModelo) {
		return this.service.save(categoriaModelo);
	}
	
	//ACTUALIZAMOS
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CategoriaModelo update(@PathVariable String id,@RequestBody CategoriaModelo categoriaModelo) {
		Optional<CategoriaModelo> op = this.service.findById(id);
		
		if (!op.isEmpty()) {
			CategoriaModelo categoriaModeloUpdate = new CategoriaModelo();
			categoriaModeloUpdate = op.get();
			categoriaModeloUpdate = categoriaModelo;
			categoriaModeloUpdate.setId(id);
			return this.service.save(categoriaModeloUpdate);
		}
		return categoriaModelo;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void delete(@PathVariable String id) {
		this.service.deleteById(id);
	}
	
}

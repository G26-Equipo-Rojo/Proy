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

import com.unab.MAR_ABIERTO_C4.Modelo.ProductoModelo;
import com.unab.MAR_ABIERTO_C4.Service.IProductoService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	//CONSULTAR TODO
	@GetMapping
	public List<ProductoModelo> all(){
		return this.service.all();
	}
	
	//CONSULTAR POR {ID}
	@GetMapping("{id}")
	public Optional<ProductoModelo> show(@PathVariable String id){
		return this.service.findById(id);
	}
	
	//CREAMOS-INSERTAMOS
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductoModelo save(@RequestBody ProductoModelo ProductoModelo) {
		return this.service.save(ProductoModelo);
	}
	
	//ACTUALIZAMOS
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductoModelo update(@PathVariable String id,@RequestBody ProductoModelo productoModelo) {
		Optional<ProductoModelo> op = this.service.findById(id);
		
		if (!op.isEmpty()) {
			ProductoModelo productoModeloUpdate = new ProductoModelo();
			productoModeloUpdate = op.get();
			productoModeloUpdate = productoModelo;
			productoModeloUpdate.setId(id);
			return this.service.save(productoModeloUpdate);
		}
		return productoModelo;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void delete(@PathVariable String id) {
		this.service.deleteById(id);
	}

}

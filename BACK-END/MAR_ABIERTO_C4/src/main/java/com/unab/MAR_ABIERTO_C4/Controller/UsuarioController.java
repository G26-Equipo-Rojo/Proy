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

import com.unab.MAR_ABIERTO_C4.Modelo.UsuarioModelo;
import com.unab.MAR_ABIERTO_C4.Service.IUsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	//CONSULTAR TODO
	@GetMapping
	public List<UsuarioModelo> all(){
		return this.service.all();
	}
	
	//CONSULTAR POR {ID}
	@GetMapping("{id}")
	public Optional<UsuarioModelo> show(@PathVariable String id){
		return this.service.findById(id);
	}
	
	//CREAMOS-INSERTAMOS
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioModelo save(@RequestBody UsuarioModelo UsuarioModelo) {
		return this.service.save(UsuarioModelo);
	}
	
	//ACTUALIZAMOS
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioModelo update(@PathVariable String id,@RequestBody UsuarioModelo usuarioModelo) {
		Optional<UsuarioModelo> op = this.service.findById(id);
		
		if (!op.isEmpty()) {
			UsuarioModelo usuarioModeloUpdate = new UsuarioModelo();
			usuarioModeloUpdate = op.get();
			usuarioModeloUpdate = usuarioModelo;
			usuarioModeloUpdate.setId(id);
			return this.service.save(usuarioModeloUpdate);
		}
		return usuarioModelo;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void delete(@PathVariable String id) {
		this.service.deleteById(id);
	}

}

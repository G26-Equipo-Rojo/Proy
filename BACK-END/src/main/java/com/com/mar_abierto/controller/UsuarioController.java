package com.com.mar_abierto.controller;

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

import com.com.mar_abierto.entity.UsuarioEntity;
import com.com.mar_abierto.service.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	//Accedemos a los metodos de la interface de usuarioService
	@Autowired
	private IUsuarioService usuarioService;

	//Con el metodo GET sin parametros consultamos todos los registros
	@GetMapping
	public List<UsuarioEntity> all(){
		return this.usuarioService.all();
	}
	
	//Con el metodo GET con parametros consultamos los registros por ID
	@GetMapping("{id}")
	public Optional<UsuarioEntity> show(@PathVariable Long id){
		return this.usuarioService.findById(id);
	}
	
	//Con el metodo POST creamos los registros
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioEntity save (@RequestBody UsuarioEntity usuarioEntity) {
		return this.usuarioService.save(usuarioEntity);
	}
	
	//Con el metodo PUT actualizamos los registros por ID
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioEntity update(@PathVariable Long id, @RequestBody UsuarioEntity usuarioEntity) {
		Optional<UsuarioEntity> op = usuarioService.findById(id);
		
		if (!op.isEmpty()) {
			
			UsuarioEntity usuarioEntityUpdate = op.get();
			usuarioEntityUpdate.setCorreo(usuarioEntity.getCorreo());
			usuarioEntityUpdate.setNombre(usuarioEntity.getNombre());
			usuarioEntityUpdate.setIdentificacion(usuarioEntity.getIdentificacion());
			usuarioEntityUpdate.setApellido(usuarioEntity.getApellido());
			usuarioEntityUpdate.setContrasena(usuarioEntity.getContrasena());
			
			return usuarioService.save(usuarioEntityUpdate);
			
		}
		
		return usuarioEntity;
	}
	
	//Con el metodo DELETE eliminamos los registros por ID
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.usuarioService.deleteById(id);
	}

}

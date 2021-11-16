package com.unab.aerolinea.Controller;

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

import com.unab.aerolinea.Entity.Ciudades;
import com.unab.aerolinea.Service.ICiudadesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ciudades")
public class CiudadesController {

	@Autowired
	private ICiudadesService service;

	@GetMapping
	public List<Ciudades> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Ciudades> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ciudades save(@RequestBody Ciudades ciudades) {
		return service.save(ciudades);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ciudades update(@PathVariable Long id, @RequestBody Ciudades ciudades) {
		Optional<Ciudades> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Ciudades ciudadesUpdate = op.get();
			ciudadesUpdate.setCodigo_dane(ciudades.getCodigo_dane());
			ciudadesUpdate.setDescripcion(ciudades.getDescripcion());
			return service.save(ciudadesUpdate);
		}
		
		return ciudades;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
}

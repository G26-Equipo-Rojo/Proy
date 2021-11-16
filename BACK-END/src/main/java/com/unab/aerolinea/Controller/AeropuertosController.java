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

import com.unab.aerolinea.Entity.Aeropuertos;
import com.unab.aerolinea.Service.IAeropuertosService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/aeropuertos")
public class AeropuertosController {

	@Autowired
	private IAeropuertosService service;

	@GetMapping
	public List<Aeropuertos> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Aeropuertos> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aeropuertos save(@RequestBody Aeropuertos aeropuertos) {
		return service.save(aeropuertos);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aeropuertos update(@PathVariable Long id, @RequestBody Aeropuertos aeropuertos) {
		Optional<Aeropuertos> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Aeropuertos aeropuertosUpdate = op.get();
			aeropuertosUpdate.setNombre(aeropuertos.getNombre());
			aeropuertosUpdate.setCantidad_pista(aeropuertos.getCantidad_pista());
			aeropuertosUpdate.setCantidad_sala(aeropuertos.getCantidad_sala());
			aeropuertosUpdate.setIdCiudad(aeropuertos.getIdCiudad());
			return service.save(aeropuertosUpdate);
		}
		
		return aeropuertos;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}

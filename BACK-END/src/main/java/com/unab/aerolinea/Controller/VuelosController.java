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

import com.unab.aerolinea.Entity.Vuelos;
import com.unab.aerolinea.Service.IVuelosService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/vuelos")
public class VuelosController {

	@Autowired
	private IVuelosService service;

	@GetMapping
	public List<Vuelos> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Vuelos> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Vuelos save(@RequestBody Vuelos vuelos) {
		return service.save(vuelos);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Vuelos update(@PathVariable Long id, @RequestBody Vuelos vuelos) {
		Optional<Vuelos> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Vuelos vuelosUpdate = op.get();
			vuelosUpdate.setHora_salida(vuelos.getHora_salida());
			vuelosUpdate.setHora_llegada(vuelos.getHora_llegada());
			vuelosUpdate.setFecha_salida(vuelos.getFecha_salida());
			vuelosUpdate.setFecha_llegada(vuelos.getFecha_llegada());
			vuelosUpdate.setCantidad_pasajeros(vuelos.getCantidad_pasajeros());
			vuelosUpdate.setIdAeropuerto_Salida(vuelos.getIdAeropuerto_Salida());
			vuelosUpdate.setIdAeropuerto_llegada(vuelos.getIdAeropuerto_llegada());
			vuelosUpdate.setIdAvion(vuelos.getIdAvion());
			return service.save(vuelos);
		}
		
		return vuelos;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}

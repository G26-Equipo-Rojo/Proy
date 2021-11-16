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

import com.unab.aerolinea.Entity.Tripulantes;
import com.unab.aerolinea.Service.ITripulantesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/tripulantes")
public class TripulantesController {

	@Autowired
	private ITripulantesService service;

	@GetMapping
	public List<Tripulantes> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Tripulantes> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tripulantes save(@RequestBody Tripulantes tripulantes) {
		return service.save(tripulantes);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tripulantes update(@PathVariable Long id, @RequestBody Tripulantes tripulantes) {
		Optional<Tripulantes> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Tripulantes tripulantesUpdate = op.get();
			tripulantesUpdate.setFuncion(tripulantes.getFuncion());
			tripulantesUpdate.setIdPersona(tripulantes.getIdPersona());
			return service.save(tripulantes);
		}
		
		return tripulantes;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	
	
}

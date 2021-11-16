package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.aerolinea.Entity.Tripulantes;
import com.unab.aerolinea.Repository.ITripulantesRepository;

@Service
public class TripulantesService implements ITripulantesService{
	
	@Autowired
	private ITripulantesRepository repository;
	
	@Override
	public List<Tripulantes> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Tripulantes> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Tripulantes save(Tripulantes tripulantes) {
		return this.repository.save(tripulantes);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	

}

package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.aerolinea.Entity.Tripulantes_Aviones;
import com.unab.aerolinea.Repository.ITripulantes_AvionesRepository;

@Service
public class Tripulantes_AvionesService implements ITripulantes_AvionesService{

	@Autowired
	private ITripulantes_AvionesRepository repository;
	
	@Override
	public List<Tripulantes_Aviones> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Tripulantes_Aviones> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Tripulantes_Aviones save(Tripulantes_Aviones tripulantes_aviones) {
		return this.repository.save(tripulantes_aviones);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	

	
}

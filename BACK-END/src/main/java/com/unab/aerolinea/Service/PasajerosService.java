package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.aerolinea.Entity.Pasajeros;
import com.unab.aerolinea.Repository.IPasajerosRepository;

@Service
public class PasajerosService implements IPasajerosService{

	@Autowired
	private IPasajerosRepository repository;
	
	@Override
	public List<Pasajeros> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Pasajeros> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Pasajeros save(Pasajeros pasajeros) {
		return this.repository.save(pasajeros);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	
}

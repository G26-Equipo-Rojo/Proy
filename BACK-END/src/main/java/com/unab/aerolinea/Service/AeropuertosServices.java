package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.aerolinea.Entity.Aeropuertos;
import com.unab.aerolinea.Repository.IAeropuertosRepository;

@Service
public class AeropuertosServices implements IAeropuertosService {

	@Autowired
	private IAeropuertosRepository repository;
	
	@Override
	public List<Aeropuertos> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Aeropuertos> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Aeropuertos save(Aeropuertos aeropuertos) {
		return this.repository.save(aeropuertos);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	
}

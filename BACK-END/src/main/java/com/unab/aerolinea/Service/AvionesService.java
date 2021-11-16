package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.aerolinea.Entity.Aviones;
import com.unab.aerolinea.Repository.IAvionesRepository;

@Service
public class AvionesService implements IAvionesService{

	@Autowired
	private IAvionesRepository repository;
	
	@Override
	public List<Aviones> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Aviones> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Aviones save(Aviones aviones) {
		return this.repository.save(aviones);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	
}

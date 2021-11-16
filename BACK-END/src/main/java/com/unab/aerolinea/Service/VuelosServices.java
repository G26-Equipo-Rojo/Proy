package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.aerolinea.Entity.Vuelos;
import com.unab.aerolinea.Repository.IVuelosRepository;

@Service
public class VuelosServices implements IVuelosService{

	
	@Autowired
	private IVuelosRepository repository;
	
	@Override
	public List<Vuelos> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Vuelos> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Vuelos save(Vuelos vuelos) {
		return this.repository.save(vuelos);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	
}

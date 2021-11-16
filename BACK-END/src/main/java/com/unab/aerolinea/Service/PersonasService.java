package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.aerolinea.Entity.Personas;
import com.unab.aerolinea.Repository.IPersonasRepository;

@Service
public class PersonasService implements IPersonasService {
	
	
	@Autowired
	private IPersonasRepository repository;
	
	@Override
	public List<Personas> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Personas> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Personas save(Personas personas) {
		return this.repository.save(personas);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	

}

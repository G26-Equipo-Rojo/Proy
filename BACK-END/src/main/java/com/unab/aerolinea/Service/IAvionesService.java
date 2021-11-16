package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import com.unab.aerolinea.Entity.Aviones;

public interface IAvionesService {

	public List<Aviones> all();
	
	public Optional<Aviones> findById(Long id);
	
	public Aviones save(Aviones aviones);
	
	public void delete(Long id);
}

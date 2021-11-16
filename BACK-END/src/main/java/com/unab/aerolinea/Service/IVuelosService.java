package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import com.unab.aerolinea.Entity.Vuelos;

public interface IVuelosService {
	
	public List<Vuelos> all();
	
	public Optional<Vuelos> findById(Long id);
	
	public Vuelos save(Vuelos vuelos);
	
	public void delete(Long id);
}

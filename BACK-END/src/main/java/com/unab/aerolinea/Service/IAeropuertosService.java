package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import com.unab.aerolinea.Entity.Aeropuertos;

public interface IAeropuertosService {
	
	public List<Aeropuertos> all();
	
	public Optional<Aeropuertos> findById(Long id);
	
	public Aeropuertos save(Aeropuertos aeropuertos);
	
	public void delete(Long id);
}

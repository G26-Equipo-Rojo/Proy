package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import com.unab.aerolinea.Entity.Pasajeros;

public interface IPasajerosService {
	
	public List<Pasajeros> all();
	
	public Optional<Pasajeros> findById(Long id);
	
	public Pasajeros save(Pasajeros pasajeros);
	
	public void delete(Long id);
}

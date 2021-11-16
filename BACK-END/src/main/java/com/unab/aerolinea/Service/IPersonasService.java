package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import com.unab.aerolinea.Entity.Personas;

public interface IPersonasService {
	
	public List<Personas> all();
	
	public Optional<Personas> findById(Long id);
	
	public Personas save(Personas parsonas);
	
	public void delete(Long id);
}

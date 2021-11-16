package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import com.unab.aerolinea.Entity.Tripulantes;

public interface ITripulantesService {

	public List<Tripulantes> all();
	
	public Optional<Tripulantes> findById(Long id);
	
	public Tripulantes save(Tripulantes tripulantes);
	
	public void delete(Long id);
	
}

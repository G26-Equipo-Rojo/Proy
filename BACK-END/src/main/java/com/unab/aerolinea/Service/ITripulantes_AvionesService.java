package com.unab.aerolinea.Service;

import java.util.List;
import java.util.Optional;

import com.unab.aerolinea.Entity.Tripulantes_Aviones;

public interface ITripulantes_AvionesService {

	public List<Tripulantes_Aviones> all();
	
	public Optional<Tripulantes_Aviones> findById(Long id);
	
	public Tripulantes_Aviones save(Tripulantes_Aviones tripulantes_aviones);
	
	public void delete(Long id);
		
}

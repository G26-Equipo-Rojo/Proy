package com.unab.MAR_ABIERTO_C4.ServiceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.MAR_ABIERTO_C4.Modelo.CategoriaModelo;
import com.unab.MAR_ABIERTO_C4.Repository.ICategoriaRepository;
import com.unab.MAR_ABIERTO_C4.Service.ICategoriaService;

@Service
public class CategoriaServiceImplement implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepository repository;
	
	@Override
	public List<CategoriaModelo> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<CategoriaModelo> findById(String id) {
		return this.repository.findById(id);
	}

	@Override
	public CategoriaModelo save(CategoriaModelo categoriaModelo) {
		return this.repository.save(categoriaModelo);
	}

	@Override
	public void deleteById(String id) {
		this.repository.deleteById(id);
		
	}

}

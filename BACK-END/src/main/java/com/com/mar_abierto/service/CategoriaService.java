package com.com.mar_abierto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.mar_abierto.entity.CategoriaEntity;
import com.com.mar_abierto.repository.CategoriaRepository;


@Service
public class CategoriaService implements ICategoriaService{
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<CategoriaEntity> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<CategoriaEntity> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public CategoriaEntity save(CategoriaEntity inventarioEntity) {
		return this.repository.save(inventarioEntity);
	}

	@Override
	public void deleteById(Long id) {
		this.repository.deleteById(id);
		
	}

}

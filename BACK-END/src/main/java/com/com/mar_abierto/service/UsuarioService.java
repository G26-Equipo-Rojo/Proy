package com.com.mar_abierto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.mar_abierto.entity.UsuarioEntity;
import com.com.mar_abierto.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<UsuarioEntity> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<UsuarioEntity> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public UsuarioEntity save(UsuarioEntity usuarioEntity) {
		return this.repository.save(usuarioEntity);
	}

	@Override
	public void deleteById(Long id) {
		this.repository.deleteById(id);
		
	}

}

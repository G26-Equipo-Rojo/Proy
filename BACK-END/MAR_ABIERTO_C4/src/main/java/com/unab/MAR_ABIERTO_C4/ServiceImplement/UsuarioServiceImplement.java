package com.unab.MAR_ABIERTO_C4.ServiceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.MAR_ABIERTO_C4.Modelo.UsuarioModelo;
import com.unab.MAR_ABIERTO_C4.Repository.IUsuarioRepository;
import com.unab.MAR_ABIERTO_C4.Service.IUsuarioService;

@Service
public class UsuarioServiceImplement implements IUsuarioService{

	
	@Autowired
	private IUsuarioRepository repository;
	
	@Override
	public List<UsuarioModelo> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<UsuarioModelo> findById(String id) {
		return this.repository.findById(id);
	}

	@Override
	public UsuarioModelo save(UsuarioModelo usuarioModelo) {
		return this.repository.save(usuarioModelo);
	}

	@Override
	public void deleteById(String id) {
		this.repository.deleteById(id);
		
	}

}

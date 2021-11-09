package com.com.mar_abierto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.com.mar_abierto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
}

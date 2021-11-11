package com.unab.marabierto.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.marabierto.entity.ProductosEntity;
import com.unab.marabierto.repository.IProductosRepository;

@Service
public class ProductosService implements IProductosService {
	
	@Autowired
	private IProductosRepository repository;
	
	@Override
	public List<ProductosEntity> all() {
		return this.repository.findAll();
	}	
	
	@Override
	public Optional<ProductosEntity> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public ProductosEntity save(ProductosEntity productosEntity) {
		return this.repository.save(productosEntity);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}

package com.unab.marabierto.service;

import java.util.List;
import java.util.Optional;

import com.unab.marabierto.entity.ProductosEntity;

public interface IProductosService {

	public List<ProductosEntity> all();
	
	public Optional<ProductosEntity> findById(Long id);
	
	public ProductosEntity save(ProductosEntity productosEntity);
	
	public void delete(Long id);
}

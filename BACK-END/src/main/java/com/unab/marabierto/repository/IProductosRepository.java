package com.unab.marabierto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.marabierto.entity.ProductosEntity;

public interface IProductosRepository extends JpaRepository<ProductosEntity, Long> {
	
}


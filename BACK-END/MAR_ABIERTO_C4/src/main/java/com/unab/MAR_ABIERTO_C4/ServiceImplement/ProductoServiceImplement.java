package com.unab.MAR_ABIERTO_C4.ServiceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.MAR_ABIERTO_C4.Modelo.ProductoModelo;
import com.unab.MAR_ABIERTO_C4.Repository.IProductoRepository;
import com.unab.MAR_ABIERTO_C4.Service.IProductoService;

@Service
public class ProductoServiceImplement implements IProductoService{

	
	@Autowired
	private IProductoRepository repository;
	
	@Override
	public List<ProductoModelo> all() {
		return this.repository.findAll();
	}

	@Override
	public Optional<ProductoModelo> findById(String id) {
		return this.repository.findById(id);
	}

	@Override
	public ProductoModelo save(ProductoModelo usuarioModelo) {
		return this.repository.save(usuarioModelo);
	}

	@Override
	public void deleteById(String id) {
		this.repository.deleteById(id);
		
	}

}

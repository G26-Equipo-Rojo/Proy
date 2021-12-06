package com.unab.MAR_ABIERTO_C4.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.MAR_ABIERTO_C4.Modelo.ProductoModelo;

public interface IProductoRepository extends MongoRepository<ProductoModelo, String>{

}

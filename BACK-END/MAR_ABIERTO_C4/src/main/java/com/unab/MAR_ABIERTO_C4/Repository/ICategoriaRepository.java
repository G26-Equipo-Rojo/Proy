package com.unab.MAR_ABIERTO_C4.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unab.MAR_ABIERTO_C4.Modelo.CategoriaModelo;

public interface ICategoriaRepository extends MongoRepository<CategoriaModelo, String>{

}

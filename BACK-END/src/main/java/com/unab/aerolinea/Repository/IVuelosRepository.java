package com.unab.aerolinea.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.aerolinea.Entity.Vuelos;

public interface IVuelosRepository extends JpaRepository<Vuelos, Long>{

}

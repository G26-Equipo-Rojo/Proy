package com.unab.aerolinea.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.aerolinea.Entity.Aviones;

public interface IAvionesRepository extends JpaRepository<Aviones, Long> {

}

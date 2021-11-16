package com.unab.aerolinea.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.aerolinea.Entity.Personas;

public interface IPersonasRepository extends JpaRepository<Personas, Long>{

}

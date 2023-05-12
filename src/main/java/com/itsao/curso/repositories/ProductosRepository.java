package com.itsao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsao.curso.entities.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long>{
    
}

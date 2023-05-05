package com.itsao.curso.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsao.curso.entities.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
    
    boolean existsByName(String name);

    boolean existsByEmail(String email);

    Usuarios findByName(String name);

    Usuarios findByEmail(String email);

    @Transactional
    void deleteByName(String name);
    
}

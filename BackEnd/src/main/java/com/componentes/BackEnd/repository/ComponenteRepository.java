package com.componentes.BackEnd.repository;

import com.componentes.BackEnd.entity.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer> {

    Optional<Componente> findByDescripcion(String descripcion);
    boolean existsByDescripcion(String descripcion);

}

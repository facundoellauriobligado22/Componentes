package com.componentes.BackEnd.repository;

import com.componentes.BackEnd.entity.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer> {

    Optional<Componente> findByDescription(String descripcion);
    boolean existsByDescription(String descripcion);
    Optional<Componente> findAll(int id);

}

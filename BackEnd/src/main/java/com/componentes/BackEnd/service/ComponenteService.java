package com.componentes.BackEnd.service;

import com.componentes.BackEnd.entity.Componente;
import com.componentes.BackEnd.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComponenteService {

    @Autowired
    ComponenteRepository componenteRepository;

    public List<Componente> list(){
        return componenteRepository.findAll();
    }
    public Optional<Componente> getOne(int id){
        return componenteRepository.findById(id);
    }
    public Optional<Componente> getByDescripcion(String descripcion){
        return componenteRepository.findByDescripcion(descripcion);
    }
    public void save(Componente componente){
        componenteRepository.save(componente);
    }
    public void delete(int id){
        componenteRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return componenteRepository.existsById(id);
    }
    public boolean existsByDescripcion(String descripcion){
        return componenteRepository.existsByDescripcion(descripcion);
    }
}

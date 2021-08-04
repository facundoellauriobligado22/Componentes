package com.componentes.BackEnd.controller;

import com.componentes.BackEnd.dto.Mensaje;
import com.componentes.BackEnd.entity.Componente;
import com.componentes.BackEnd.service.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Componente")
@CrossOrigin(origins = "http://localhost:3306")

public class ComponenteController {

    @Autowired
    ComponenteService componenteService;

    @GetMapping("/lista")
    public ResponseEntity<List<Componente>> list(){
        List<Componente> list = componenteService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Componente> getById(@PathVariable("id") int id){
        if (!componenteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        Componente componente = componenteService.getOne(id).get();
        return new ResponseEntity(componente, HttpStatus.OK);
    }
    
}

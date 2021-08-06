package com.componentes.BackEnd.controller;

import com.componentes.BackEnd.dto.ComponenteDto;
import com.componentes.BackEnd.dto.Mensaje;
import com.componentes.BackEnd.entity.Componente;
import com.componentes.BackEnd.service.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

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
    @GetMapping("/detail/{descripcion}")
    public ResponseEntity<Componente> getByDescripcion(@PathVariable("descripcion") String descripcion){
        if (!componenteService.existsByDescription(descripcion))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        Componente componente = componenteService.getByDescripcion(descripcion).get();
        return new ResponseEntity(componente, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Componente> create (@RequestBody ComponenteDto componenteDto){
        if (componenteDto.getIdUbicacion() == 0 || componenteDto.getIdUbicacion() < 0)
            return new ResponseEntity(new Mensaje("La ubicacion es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(componenteDto.getPartNumber()))
            return new ResponseEntity(new Mensaje("El partNumber es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(componenteDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        if (componenteDto.getIdGrupo() == 0)
            return new ResponseEntity(new Mensaje("El grupo es obligatorio"), HttpStatus.BAD_REQUEST);
        if (componenteDto.getIdFabricante()==0)
            return new ResponseEntity(new Mensaje("El fabricante es obligatorio"), HttpStatus.BAD_REQUEST);
        if (componenteDto.getStock()==0)
            return new ResponseEntity(new Mensaje("El stock es obligatorio"), HttpStatus.BAD_REQUEST);
        if (componenteDto.getCodigoMap() ==0)
            return new ResponseEntity(new Mensaje("El codigoMap es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(componenteDto.getUtilizacion()))
            return new ResponseEntity(new Mensaje("La utilizacion es obligatorio"), HttpStatus.BAD_REQUEST);
        if (componenteDto.isUsoEnProduccion())
            return new ResponseEntity(new Mensaje("El usoEnProduccion es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(componenteDto.getFotoComponente()))
            return new ResponseEntity(new Mensaje("La foto es obligatorio"), HttpStatus.BAD_REQUEST);

        Componente componente = new Componente(componenteDto.getIdUbicacion(), componenteDto.getPartNumber(), componenteDto.getDescripcion(), componenteDto.getIdGrupo(), componenteDto.getIdFabricante(), componenteDto.getStock(), componenteDto.getCodigoMap(), componenteDto.getUtilizacion(), componenteDto.isUsoEnProduccion(), componenteDto.getFotoComponente());

        componenteService.save(componente);
        return new ResponseEntity(new Mensaje("Componente creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Componente> update (@PathVariable("id") int id, @RequestBody ComponenteDto componenteDto){
        if (!componenteService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if (componenteService.existsByDescription(componenteDto.getDescripcion()) && componenteService.getByDescripcion(componenteDto.getDescripcion()).get().getIdComponente() != id)
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);

            Componente c = componenteService.getOne(id).get();

        componenteService.save(c);
        return new ResponseEntity(new Mensaje("Componente modificado"), HttpStatus.OK);
    }
    public ResponseEntity<Componente> delete (@PathVariable("id")int id){
        if (!componenteService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        componenteService.delete(id);
        return new ResponseEntity(new Mensaje("Componente eliminado"), HttpStatus.OK);
    }
    
}

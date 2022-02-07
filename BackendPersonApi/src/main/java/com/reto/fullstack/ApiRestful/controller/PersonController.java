package com.reto.fullstack.ApiRestful.controller;

import com.reto.fullstack.ApiRestful.exception.BadRequestException;
import com.reto.fullstack.ApiRestful.model.dtos.PersonDto;
import com.reto.fullstack.ApiRestful.model.entities.Person;
import com.reto.fullstack.ApiRestful.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    private ResponseEntity<?> registrarPerson(@RequestBody Person person) throws BadRequestException, URISyntaxException {


        Person temporal = personService.create(person);
        return ResponseEntity.created(new URI("/api/person"+temporal.getId())).body(HttpStatus.OK);

        //throw new BadRequestException("Este nombre ya existe");
        //throw new MercanciaException("El nombre "+temporal.getNombreProducto()+" ya existe dentro de la mercancia");

    }
    @PutMapping(value="{id}")
    private ResponseEntity<?> actualizarMercancia(@RequestBody PersonDto personDto, @PathVariable Long id) throws BadRequestException {
        personService.update(personDto,id);
        Optional<Person> person = personService.findById(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.OK);
        //return ResponseEntity.ok().build();
    }

    @GetMapping
    private ResponseEntity<List<Person>> listarMercancia(){
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @DeleteMapping
    private ResponseEntity<?> eliminarMercancia(@RequestBody Person person){
        personService.delete(person);
        //return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Person>> listarMercanciaPorId(@PathVariable("id")Long id) throws BadRequestException {
        return ResponseEntity.ok(personService.findById(id));
    }
}

package com.envios.controller;

import com.envios.models.Envio;
import com.envios.service.EnvioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/envios/envio") // Ruta 
public class EnvioController {

    @Autowired 
    private EnvioService envioService;

    // Obtener todas las  (GET)
=======
// Imports para HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;

@RestController
@RequestMapping("/envios/envio")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @GetMapping
    public ResponseEntity<List<Envio>> getAll() {
        return ResponseEntity.ok(envioService.getAll());
    }

<<<<<<< HEAD
    // Obtener  por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Envio envio = envioService.getById(id);
        if (envio != null) {
            return ResponseEntity.ok(envio);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("envio no encontrado");
        }
    }

    // Crear nuevo  (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Envio envio) {
=======
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Envio>> getById(@PathVariable Integer id) {
        Envio envio = envioService.getById(id);
        if (envio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        EntityModel<Envio> recurso = EntityModel.of(envio,
            linkTo(methodOn(EnvioController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(EnvioController.class).getAll()).withRel("envios")
        );

        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public ResponseEntity<Envio> add(@RequestBody Envio envio) {
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
        Envio nueva = envioService.add(envio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

<<<<<<< HEAD
    // Actualizar  existente (PUT)
=======
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Envio envio) {
        Envio actualizada = envioService.update(id, envio);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("envio no encontrado");
        }
    }

<<<<<<< HEAD
    // Eliminar  (DELETE)
=======
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Envio eliminada = envioService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("envio no encontrado");
        }
    }
}
<<<<<<< HEAD

=======
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)

package com.envios.controller;

import com.envios.models.EstadoEnvio;
import com.envios.service.EstadoEnvioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/envios/estadoenvio") // Ruta 
=======
// Importaciones para HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/envios/estadoenvio") // Ruta base para este controlador
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
public class EstadoEnvioController {

    @Autowired 
    private EstadoEnvioService estadoenvioService;

<<<<<<< HEAD
    // Obtener todas las  (GET)
=======
    // Obtener todas las (GET)
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @GetMapping
    public ResponseEntity<List<EstadoEnvio>> getAll() {
        return ResponseEntity.ok(estadoenvioService.getAll());
    }

<<<<<<< HEAD
    // Obtener  por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        EstadoEnvio estadoenvio = estadoenvioService.getById(id);
        if (estadoenvio != null) {
            return ResponseEntity.ok(estadoenvio);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("estado de envio no encontrado");
        }
    }

    // Crear nuevo  (POST)
=======
    // Obtener por ID con HATEOAS (GET)
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EstadoEnvio>> getById(@PathVariable Integer id) {
        EstadoEnvio estadoenvio = estadoenvioService.getById(id);
        if (estadoenvio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        EntityModel<EstadoEnvio> recurso = EntityModel.of(estadoenvio,
            linkTo(methodOn(EstadoEnvioController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(EstadoEnvioController.class).getAll()).withRel("estadoenvios")
        );

        return ResponseEntity.ok(recurso);
    }

    // Crear nuevo (POST)
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody EstadoEnvio estadoenvio) {
        EstadoEnvio nueva = estadoenvioService.add(estadoenvio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

<<<<<<< HEAD
    // Actualizar  existente (PUT)
=======
    // Actualizar existente (PUT)
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody EstadoEnvio estadoenvio) {
        EstadoEnvio actualizada = estadoenvioService.update(id, estadoenvio);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("estado de envio no encontrado");
        }
    }

<<<<<<< HEAD
    // Eliminar  (DELETE)
=======
    // Eliminar (DELETE)
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        EstadoEnvio eliminada = estadoenvioService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("estado de envio no encontrado");
        }
    }
}
<<<<<<< HEAD

=======
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)

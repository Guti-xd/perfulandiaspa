package com.cliente.controllers;

import com.cliente.models.HistorialCompra;
import com.cliente.service.HistorialCompraService;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.hateoas.EntityModel;
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/cliente/historial_compra") // Ruta base para este controlador
public class HistorialCompraController {

    @Autowired // Inyección del servicio
    private HistorialCompraService historialcompraService;

    // Obtener todos (GET)
=======
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/cliente/historial_compra")
public class HistorialCompraController {

    @Autowired
    private HistorialCompraService historialcompraService;

>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @GetMapping
    public ResponseEntity<List<HistorialCompra>> getAll() {
        return ResponseEntity.ok(historialcompraService.getAll());
    }

<<<<<<< HEAD
    // Obtener por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        HistorialCompra historialcompra = historialcompraService.getById(id);
        if (historialcompra != null) {
            return ResponseEntity.ok(historialcompra);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("historial de compra no encontrada");
        }
    }

    // Crear   (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody HistorialCompra historialcompra) {
        HistorialCompra nueva = historialcompraService.add(historialcompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody HistorialCompra direccion) {
        HistorialCompra actualizada = historialcompraService.update(id, direccion);
=======
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<HistorialCompra>> getById(@PathVariable Integer id) {
        HistorialCompra historial = historialcompraService.getById(id);
        if (historial == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        EntityModel<HistorialCompra> recurso = EntityModel.of(historial,
            linkTo(methodOn(HistorialCompraController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(HistorialCompraController.class).getAll()).withRel("historiales")
        );

        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody HistorialCompra historial) {
        HistorialCompra nueva = historialcompraService.add(historial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody HistorialCompra historial) {
        HistorialCompra actualizada = historialcompraService.update(id, historial);
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("historial de compra no encontrada");
        }
    }

<<<<<<< HEAD
    // Eliminar  (DELETE)
=======
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        HistorialCompra eliminada = historialcompraService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("historial de compra no encontrada");
        }
    }
}

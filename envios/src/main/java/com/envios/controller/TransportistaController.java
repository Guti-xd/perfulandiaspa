package com.envios.controller;

import com.envios.models.Transportista;
import com.envios.service.TransportistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/envios/transportista") // Ruta 
public class TransportistaController {

    @Autowired 
    private TransportistaService transportistaService;

    // Obtener todas las  (GET)
    @GetMapping
    public ResponseEntity<List<Transportista>> getAll() {
        return ResponseEntity.ok(transportistaService.getAll());
    }

    // Obtener  por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Transportista transportista = transportistaService.getById(id);
        if (transportista != null) {
            return ResponseEntity.ok(transportista);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transportista no encontrado");
        }
    }

    // Crear nuevo  (POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Transportista transportista) {
        Transportista nueva = transportistaService.add(transportista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar  existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Transportista transportista) {
        Transportista actualizada = transportistaService.update(id, transportista);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transportista no encontrado");
        }
    }

    // Eliminar  (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Transportista eliminada = transportistaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transportista no encontrado");
        }
    }
}


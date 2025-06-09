package com.envios.controller;

import com.envios.models.Envio;
import com.envios.service.EnvioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/envios/envio") // Ruta 
public class EnvioController {

    @Autowired 
    private EnvioService envioService;

    // Obtener todas las  (GET)
    @GetMapping
    public ResponseEntity<List<Envio>> getAll() {
        return ResponseEntity.ok(envioService.getAll());
    }

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
        Envio nueva = envioService.add(envio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar  existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Envio envio) {
        Envio actualizada = envioService.update(id, envio);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("envio no encontrado");
        }
    }

    // Eliminar  (DELETE)
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


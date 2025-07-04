package com.cliente.controllers;

import com.cliente.models.Cliente;
import com.cliente.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
@RestController // Indica que esta clase responde a peticiones REST
@RequestMapping("/cliente/cliente") // Ruta base para este controlador
public class ClienteController {

    @Autowired // Inyección del servicio de cliente
    private ClienteService clienteService;

    // Obtener todas las clientes (GET)
=======
// Importaciones para HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;

@RestController
@RequestMapping("/cliente/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

<<<<<<< HEAD
    // Obtener cliente por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Cliente cliente = clienteService.getById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    // Crear nuevo cliente (POST)
=======
    // Método modificado para devolver HATEOAS
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> getById(@PathVariable Integer id) {
        Cliente cliente = clienteService.getById(id);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Construcción del EntityModel con enlaces
        EntityModel<Cliente> recurso = EntityModel.of(cliente,
            linkTo(methodOn(ClienteController.class).getById(id)).withSelfRel(),
            linkTo(methodOn(ClienteController.class).getAll()).withRel("clientes")
        );

        return ResponseEntity.ok(recurso);
    }

>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Cliente cliente) {
        Cliente nueva = clienteService.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

<<<<<<< HEAD
    // Actualizar cliente existente (PUT)
=======
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente actualizada = clienteService.update(id, cliente);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

<<<<<<< HEAD
    // Eliminar cliente (DELETE)
=======
>>>>>>> 2f10847 (Archivo creados, ai gateway funcionando. otros mas)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Cliente eliminada = clienteService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
}

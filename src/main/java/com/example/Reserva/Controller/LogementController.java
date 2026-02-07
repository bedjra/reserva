package com.example.Reserva.Controller;


import com.example.Reserva.Entity.Logement;
import com.example.Reserva.Service.LogementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logement")
@CrossOrigin("*")
public class LogementController {

    private final LogementService service;

    public LogementController(LogementService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Logement create(@RequestBody Logement logement) {
        return service.create(logement);
    }

    // READ ALL
    @GetMapping
    public List<Logement> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Logement getById(@PathVariable Long id) {
        return service.getById(id)
                .orElseThrow(() -> new RuntimeException("Logement non trouvé"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Logement update(@PathVariable Long id, @RequestBody Logement logement) {
        return service.update(id, logement);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
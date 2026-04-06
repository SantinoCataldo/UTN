package Guia2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Guia2.model.SaleEntity;
import Guia2.service.SaleService;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;

    @GetMapping
    public ResponseEntity<List<SaleEntity>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<SaleEntity> create(@RequestBody SaleEntity sale) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(sale));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleEntity> update(@PathVariable Long id, @RequestBody SaleEntity sale) {
        return ResponseEntity.ok(service.update(id, sale));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

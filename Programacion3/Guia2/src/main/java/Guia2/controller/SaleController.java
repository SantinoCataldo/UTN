package Guia2.controller;

import Guia2.model.dto.requestdto.SaleCreateRequestDTO;
import Guia2.model.dto.responsedto.SaleResponseDTO;
import Guia2.mapper.SaleMapper;
import Guia2.model.SaleEntity;
import Guia2.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService service;
    private final SaleMapper mapper;

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAll() {
        List<SaleResponseDTO> response = service.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toResponseDTO(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<SaleResponseDTO> create(@RequestBody SaleCreateRequestDTO saleDTO) {
        SaleEntity sale = mapper.toEntity(saleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(service.create(sale)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> update(@PathVariable Long id, @RequestBody SaleCreateRequestDTO saleDTO) {
        SaleEntity sale = mapper.toEntity(saleDTO);
        return ResponseEntity.ok(mapper.toResponseDTO(service.update(id, sale)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

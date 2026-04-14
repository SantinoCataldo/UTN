package Guia2.controller;

import Guia2.model.dto.requestdto.ProductCreateRequestDTO;
import Guia2.model.dto.responsedto.ProductResponseDTO;
import Guia2.mapper.ProductMapper;
import Guia2.model.ProductEntity;
import Guia2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> response = service.getAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toResponseDTO(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductCreateRequestDTO productDTO) {
        ProductEntity product = mapper.toEntity(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(service.create(product)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @RequestBody ProductCreateRequestDTO productDTO) {
        ProductEntity product = mapper.toEntity(productDTO);
        return ResponseEntity.ok(mapper.toResponseDTO(service.update(id, product)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package Guia2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Guia2.model.dto.responsedto.ProductResponseDTO;
import Guia2.model.dto.requestdto.ProductCreateRequestDTO;
import Guia2.repository.ProductRepository;
import Guia2.mapper.ProductMapper;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductResponseDTO> getAll() {
        return repository.findAll();
    }

    public ProductResponseDTO getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
    }

    public ProductResponseDTO create(ProductCreateRequestDTO productDto) {
        ProductResponseDTO toSave = mapper.toResponseDTO(productDto);
        return repository.save(toSave);
    }

    public ProductResponseDTO update(Long id, ProductCreateRequestDTO productDto) {

        ProductResponseDTO existing = getById(id);

        existing.setName(productDto.getName());
        existing.setPrice(productDto.getPrice());
        existing.setStock(productDto.getStock());

        return repository.update(existing)
                .orElseThrow(() -> new RuntimeException("Error al actualizar"));
    }

    public void delete(Long id) {

        ProductResponseDTO existing = getById(id);

        if (!repository.delete(existing)) {
            throw new RuntimeException("No se pudo eliminar");
        }
    }
}

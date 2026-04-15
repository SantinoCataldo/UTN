package Guia2.repository;

import Guia2.model.dto.responsedto.ProductResponseDTO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IRepository<ProductResponseDTO> {

    private final List<ProductResponseDTO> products = new ArrayList<>();
    private Long idCounter = 1L;

    public ProductRepository() {
        products.add(new ProductResponseDTO(1L, "Notebook", 1200.0, 10));
        products.add(new ProductResponseDTO(2L, "Mouse", 25.0, 50));
        products.add(new ProductResponseDTO(3L, "Teclado", 45.0, 30));
        idCounter = 4L;
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return products;
    }

    @Override
    public ProductResponseDTO save(ProductResponseDTO entity) {
        entity.setId(idCounter++);
        products.add(entity);
        return entity;
    }

    @Override
    public boolean delete(ProductResponseDTO entity) {
        return products.removeIf(p -> p.getId().equals(entity.getId()));
    }

    @Override
    public Optional<ProductResponseDTO> update(ProductResponseDTO entity) {
        return products.stream()
                .filter(p -> p.getId().equals(entity.getId()))
                .findFirst()
                .map(existing -> {
                    existing.setName(entity.getName());
                    existing.setPrice(entity.getPrice());
                    existing.setStock(entity.getStock());
                    return existing;
                });
    }

    public Optional<ProductResponseDTO> findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}

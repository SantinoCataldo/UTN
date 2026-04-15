package Guia2.repository;

import org.springframework.stereotype.Repository;
import Guia2.model.dto.responsedto.SaleResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepository implements IRepository<SaleResponseDTO> {

    private final List<SaleResponseDTO> sales = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<SaleResponseDTO> findAll() {
        return sales;
    }

    @Override
    public SaleResponseDTO save(SaleResponseDTO entity) {
        entity.setId(idCounter++);
        sales.add(entity);
        return entity;
    }

    @Override
    public boolean delete(SaleResponseDTO entity) {
        return sales.removeIf(s -> s.getId().equals(entity.getId()));
    }

    @Override
    public Optional<SaleResponseDTO> update(SaleResponseDTO entity) {
        return sales.stream()
                .filter(s -> s.getId().equals(entity.getId()))
                .findFirst()
                .map(existing -> {
                    existing.setQuantity(entity.getQuantity());
                    existing.setTotalPrice(entity.getTotalPrice());
                    return existing;
                });
    }

    public Optional<SaleResponseDTO> findById(Long id) {
        return sales.stream().filter(s -> s.getId().equals(id)).findFirst();
    }
}

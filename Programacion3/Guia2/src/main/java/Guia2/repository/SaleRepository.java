package Guia2.repository;

import org.springframework.stereotype.Repository;
import Guia2.model.SaleEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepository implements IRepository<SaleEntity> {

    private final List<SaleEntity> sales = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<SaleEntity> findAll() {
        return sales;
    }

    @Override
    public SaleEntity save(SaleEntity entity) {
        entity.setId(idCounter++);
        sales.add(entity);
        return entity;
    }

    @Override
    public boolean delete(SaleEntity entity) {
        return sales.removeIf(s -> s.getId().equals(entity.getId()));
    }

    @Override
    public Optional<SaleEntity> update(SaleEntity entity) {
        return sales.stream()
                .filter(s -> s.getId().equals(entity.getId()))
                .findFirst()
                .map(existing -> {
                    existing.setQuantity(entity.getQuantity());
                    existing.setTotalPrice(entity.getTotalPrice());
                    return existing;
                });
    }

    public Optional<SaleEntity> findById(Long id) {
        return sales.stream().filter(s -> s.getId().equals(id)).findFirst();
    }
}

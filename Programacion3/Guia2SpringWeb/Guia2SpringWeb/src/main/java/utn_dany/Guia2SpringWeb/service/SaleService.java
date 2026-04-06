package utn_dany.Guia2SpringWeb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utn_dany.Guia2SpringWeb.model.ProductEntity;
import utn_dany.Guia2SpringWeb.model.SaleEntity;
import utn_dany.Guia2SpringWeb.model.UserEntity;
import utn_dany.Guia2SpringWeb.repository.SaleRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository repository;
    private final ProductService productService;
    private final UserService userService;

    public List<SaleEntity> findAll(){return  repository.findAll();}

    public SaleEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Venta no encontrada"));
    }

    public SaleEntity create(SaleEntity sale) {
        if(sale.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        ProductEntity product = productService.getById(sale.getProductId());
        UserEntity user = userService.getById(sale.getUserId());

        if(product.getStock() < sale.getQuantity()) {
            throw new IllegalArgumentException("Stock insuficiente");
        }

        double totalPrice = product.getPrice() * sale.getQuantity();
        sale.setTotalPrice(totalPrice);

        product.setStock(product.getStock() - sale.getQuantity());
        productService.update(product.getId(), product);

        return repository.save(sale);
    }

    public SaleEntity update(Long id, SaleEntity sale) {

        SaleEntity existing = getById(id);

        if(sale.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        ProductEntity product = productService.getById(existing.getProductId());

        int prevQuantity = existing.getQuantity();
        int newQuantity = sale.getQuantity();

        int diff = newQuantity - prevQuantity;

        if(product.getStock() < diff) {
            throw new IllegalArgumentException("Stock insuficiente para actualizar la venta");
        }

        product.setStock(product.getStock() - diff);
        productService.update(product.getId(), product);

        double newTotalPrice = product.getPrice() * newQuantity;
        existing.setQuantity(newQuantity);
        existing.setTotalPrice(newTotalPrice);

        return repository.update(existing)
                .orElseThrow(() -> new RuntimeException("Error al actualizar"));
    }

    public void delete(Long id) {

        SaleEntity existing = getById(id);

        if (!repository.delete(existing)) {
            throw new RuntimeException("No se pudo eliminar");
        }
    }
}

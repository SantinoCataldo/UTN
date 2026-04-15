package Guia2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Guia2.model.dto.responsedto.ProductResponseDTO;
import Guia2.model.dto.responsedto.SaleResponseDTO;
import Guia2.model.dto.requestdto.SaleCreateRequestDTO;
import Guia2.model.dto.responsedto.UserResponseDTO;
import Guia2.repository.SaleRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository repository;
    private final ProductService productService;
    private final UserService userService;

    public List<SaleResponseDTO> findAll(){return  repository.findAll();}

    public SaleResponseDTO getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Venta no encontrada"));
    }

    public SaleResponseDTO create(SaleCreateRequestDTO saleDto) {
        if(saleDto.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        ProductResponseDTO product = productService.getById(saleDto.getProductId());
        UserResponseDTO user = userService.getById(saleDto.getUserId());

        if(product.getStock() < saleDto.getQuantity()) {
            throw new IllegalArgumentException("Stock insuficiente");
        }

        double totalPrice = product.getPrice() * saleDto.getQuantity();
        SaleResponseDTO toSave = new SaleResponseDTO();
        toSave.setUserId(user.getId());
        toSave.setProductId(product.getId());
        toSave.setQuantity(saleDto.getQuantity());
        toSave.setTotalPrice(totalPrice);

        product.setStock(product.getStock() - saleDto.getQuantity());
        productService.update(product.getId(), new Guia2.model.dto.requestdto.ProductCreateRequestDTO(product.getName(), product.getPrice(), product.getStock()));

        return repository.save(toSave);
    }

    public SaleResponseDTO update(Long id, SaleCreateRequestDTO saleDto) {

        SaleResponseDTO existing = getById(id);

        if(saleDto.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        ProductResponseDTO product = productService.getById(existing.getProductId());

        int prevQuantity = existing.getQuantity();
        int newQuantity = saleDto.getQuantity();

        int diff = newQuantity - prevQuantity;

        if(product.getStock() < diff) {
            throw new IllegalArgumentException("Stock insuficiente para actualizar la venta");
        }

        product.setStock(product.getStock() - diff);
        productService.update(product.getId(), new Guia2.model.dto.requestdto.ProductCreateRequestDTO(product.getName(), product.getPrice(), product.getStock()));

        double newTotalPrice = product.getPrice() * newQuantity;
        existing.setQuantity(newQuantity);
        existing.setTotalPrice(newTotalPrice);

        return repository.update(existing)
                .orElseThrow(() -> new RuntimeException("Error al actualizar"));
    }

    public void delete(Long id) {

        SaleResponseDTO existing = getById(id);

        if (!repository.delete(existing)) {
            throw new RuntimeException("No se pudo eliminar");
        }
    }
}

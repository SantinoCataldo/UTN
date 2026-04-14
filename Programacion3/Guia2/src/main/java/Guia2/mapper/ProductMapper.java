package Guia2.mapper;

import Guia2.model.dto.requestdto.ProductCreateRequestDTO;
import Guia2.model.dto.responsedto.ProductResponseDTO;
import Guia2.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    ProductEntity toEntity(ProductCreateRequestDTO dto);

    ProductResponseDTO toResponseDTO(ProductEntity entity);
}

